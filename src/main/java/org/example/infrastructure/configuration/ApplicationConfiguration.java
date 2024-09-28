package org.example.infrastructure.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.example.ComponentScanMarker;
import org.example.infrastructure.database.entity._EntityMarker;
import org.example.infrastructure.database.repository.jpa._JpaRepositoriesMarker;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.Location;
import org.flywaydb.core.api.configuration.ClassicConfiguration;
import org.hibernate.cfg.Environment;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.*;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import javax.sql.DataSource;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Properties;


@Configuration
@AllArgsConstructor
@EnableJpaRepositories(basePackageClasses = _JpaRepositoriesMarker.class)
@PropertySource({"classpath:database.properties"})
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan(basePackageClasses = ComponentScanMarker.class)
public class ApplicationConfiguration implements WebMvcConfigurer, ApplicationContextAware {

    private final org.springframework.core.env.Environment environment;

    @Setter
    private ApplicationContext applicationContext;

    @Bean
    @DependsOn("flyway")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan(_EntityMarker.class.getPackageName());
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setJpaProperties(jpaProperties());
        return entityManagerFactoryBean;
    }

    private Properties jpaProperties() {
        final Properties properties = new Properties();
        properties.setProperty(Environment.DIALECT, environment.getProperty(Environment.DIALECT));
        properties.setProperty(Environment.HBM2DDL_AUTO, environment.getProperty(Environment.HBM2DDL_AUTO));
        properties.setProperty(Environment.SHOW_SQL, environment.getProperty(Environment.SHOW_SQL));
        properties.setProperty(Environment.FORMAT_SQL, environment.getProperty(Environment.FORMAT_SQL));
        return properties;
    }

    @Bean
    public PlatformTransactionManager transactionManager(
            final EntityManagerFactory entityManagerFactory
    ) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslator() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean(initMethod = "migrate")
    Flyway flyway() {
        ClassicConfiguration configuration = new ClassicConfiguration();
        configuration.setBaselineOnMigrate(true);
        configuration.setLocations(new Location("classpath:flyway/migration"));
        configuration.setDataSource(dataSource());
        return new Flyway(configuration);
    }

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        String driverClassName = environment.getProperty(Environment.DRIVER);
        String url = environment.getProperty(Environment.URL);
        String username = environment.getProperty(Environment.USER);
        String password = environment.getProperty(Environment.PASS);

        if (driverClassName == null || url == null || username == null || password == null) {
            throw new IllegalArgumentException("Brakujące właściwości połączenia z bazą danych | driverClassName: " + driverClassName +
                    "| url: " + url + "| username: " + username + "| password: " + password);
        }

        hikariConfig.setDriverClassName(driverClassName);
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        hikariConfig.setConnectionTestQuery("SELECT 1");
        hikariConfig.setPoolName("springHikariCP");

        hikariConfig.setMaximumPoolSize(20);
        hikariConfig.setConnectionTimeout(20000);
        hikariConfig.setMinimumIdle(10);
        hikariConfig.setIdleTimeout(300000);

        return new HikariDataSource(hikariConfig);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(this.applicationContext);
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
        templateResolver.setTemplateMode(TemplateMode.HTML);
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
        return resolver;
    }
}

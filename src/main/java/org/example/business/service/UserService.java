package org.example.business.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.business.dao.UserDAO;
import org.example.domain.User;
import org.example.infrastructure.database.entity.UserEntity;
import org.example.infrastructure.database.repository.mapper.UserEntityMapper;
import org.example.infrastructure.database.repository.mapper.UserMetricEntityMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {
    private final UserDAO userDAO;
    private final UserEntityMapper userEntityMapper;
    private final UserMetricEntityMapper userMetricEntityMapper;

    // wczesniej to byla metoda verifyUser
    public boolean checkIfUserCredentialsCorrect(String username, String password) {
        log.info("##### UserService ### verifyUser");

        if(!isUserExist(username)){
            log.info("### Ziomek nie istniejesz u nas lol ###");
            return false;
        }

        String userPassword = userDAO.findByUsername(username).get().getPassword();
        log.info("##### UserService ### verifyUser ### userPassword {}",userPassword);

        if (userPassword.equals(password)) return true;
        return false;
    }

    public double calculateCPM(String gender, int age, double weight, double height, double activity, int targetAction) {
        if(age<4) return 1000;
        else if(age<7) return 1400;
        else if(age<10 && activity>1.2) return 2100;
        else if(age<10)  return 1800;

        boolean isWoman = false;
        if(gender.equals("Kobieta")) isWoman = true;

        double value1 =  formulaHarrisBenedict(isWoman, age, weight, height);
        double value2 =  formulaMifflin(isWoman, age, weight, height);
        double cpm = (value1*activity+value2*activity)/2;
        log.info("### UserService ### calculateCalories ### RESULT: {}", cpm);

        if(targetAction != 1) return cpm;
        if(cpm*0.2<500) return cpm*0.8;
        return cpm-500;
        /*
            to dla ciebie Daniel <3
            return age<4 ? 1000 : age<7 ? 1400 : (age<10 && activity>1.2) ? 2100 : age<10 ? 1800 :
                   targetAction != 1 ? (value1*activity+value2*activity)/2 :
                   (value1*activity+value2*activity)/2*0.2<500 ? (value1*activity+value2*activity)/2*0.8 :
                   (value1*activity+value2*activity)/2-500;
         */
    }
    //TODO MP obsłużyć w html czy ktos chce schudnac a jak jest za chudy to ze nie tedy droga złamasie
    public double calculateVMC(String gender, double height){
        boolean isWoman = false;
        if(gender.equals("Kobieta")) isWoman = true;

        double value1 = formulaLorentz(isWoman, height);
        double value2 = formulaPotton(isWoman, height);
        double value3 = formulaBroc(isWoman, height);

        return (value1+value2+value3)/3;
    }

    public boolean isUserExist(String username) {
        log.info("##### UserService ### isUserExist");
        Optional<User> user = userDAO.findByUsername(username);
        if (user.isPresent()) return true;
        return false;
    }
    public boolean createUser(User user) {
        //UserMetricEntity userMetricEntity = userMetricEntityMapper.mapToEntity(user.getUserMetric());
        log.info("##### UserService ### createUser ### user: {}",user);

        UserEntity userEntity = userEntityMapper.mapToEntity(user);
        //userEntity.setUserMetricEntity(userMetricEntity);
        log.info("##### UserService ### createUser ### user: {}",userEntity);


        userDAO.save(userEntity);


        Optional<User> byUsername = userDAO.findByUsername(user.getUsername());
        log.info("##### UserService ### createUser ### user: {}",byUsername);

        if(byUsername != null &&  byUsername.isPresent()){
            log.info("##### UserService ### createUser ### if 'true'");
            return true;
        }
        return false;
    }

    private double formulaHarrisBenedict(boolean isWoman, int age, double weight, double height) {
        return isWoman ? (655.1 + (9.563 * weight) + (1.85 * height) - (4.676 * age)) :
                (66.473 + (13.752 * weight) + (5.003 * height) - (6.775 * age));
    }

    private double formulaMifflin(boolean isWoman, int age, double weight, double height) {
        return isWoman ? (10 * weight) + (6.25 * height) + (5 * age) - 161 :
                (10 * weight) + (6.25 * height) + (5 * age) + 5;
    }

    private double formulaLorentz(boolean isWoman, double height){
        return isWoman ? height-100-0.5*(height-150) : height-100-0.25*(height-150);
    }
    private double formulaPotton(boolean isWoman, double height){
        return isWoman ? height-100-(height-100)/10 : height-100-(height-100)/20;
    }
    private double formulaBroc(boolean isWoman, double height){
        return isWoman ? height-100*0.9 : height-100*0.95;
    }
}

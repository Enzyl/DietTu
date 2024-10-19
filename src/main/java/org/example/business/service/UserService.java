package org.example.business.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.api.dto.UserRegisterRequestDTO;
import org.example.business.dao.UserDAO;
import org.example.domain.User;
import org.example.infrastructure.database.entity.UserEntity;
import org.example.infrastructure.database.entity.UserMetricEntity;
import org.example.infrastructure.database.repository.UserRepository;
import org.example.infrastructure.database.repository.mapper.UserEntityMapper;
import org.example.infrastructure.database.repository.mapper.UserMetricEntityMapper;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@AllArgsConstructor
public class UserService {
    private final UserDAO userDAO;
    private final UserEntityMapper userEntityMapper;
    private final UserMetricEntityMapper userMetricEntityMapper;
    public boolean verifyUser(String username, String password) {
        log.info("##### UserService ### verifyUser");
        String userPassword = userDAO.findByUsername(username).getPassword();
        if (userPassword.equals(password)){
            return true;
        }
        return false;
    }

    private double formulaHarrisBenedict(boolean isWoman, int age, double weight, double height){
        return isWoman ? (655.1 + (9.563 * weight) + (1.85 * height) - (4.676 * age)):
                        (66.473 + (13.752*weight) + (5.003*height) - (6.775 * age));
    }
    private double formulaMifflin(boolean isWoman, int age, double weight, double height){
        return isWoman ? (10*weight) + (6.25*height) + (5*age) - 161:
                        (10*weight) + (6.25*height) + (5*age) + 5;
    }
    public double calculateCalories(String gender, int age, double weight, double height, double activity) {
        if(age<4) return 1000;
        else if(age<7) return 1400;
        else if(age<10 && activity>1.2) return 2100;
        else if(age<10)  return 1800;

        double value1;
        double value2;

        boolean isWoman = false;
        if(gender.equals("Kobieta")) isWoman = true;

       value1 =  formulaHarrisBenedict(isWoman, age, weight, height);
       value2 =  formulaMifflin(isWoman, age, weight, height);

        log.info("### UserService ### calculateCalories ### RESULT: {}",(value1*activity+value2*activity)/2);
        /*
            to dla ciebie Daniel <3
            return age<4 ? 1000 : age<7 ? 1400 : (age<10 && activity>1.2) ? 2100 : age<10 ? 1800 : (value1*activity+value2*activity)/2;
         */
        return (value1*activity+value2*activity)/2;
    }

    public boolean isUserExist(String username) {
        log.info("##### UserService ### verifyUser");
        User user = userDAO.findByUsername(username);
        return user != null ? true : false;
    }

    public boolean createUser(User user) {
        UserMetricEntity userMetricEntity = userMetricEntityMapper.mapToEntity(user.getUserMetric());

        UserEntity userEntity = userEntityMapper.mapToEntity(user);
        userEntity.setUserMetricEntity(userMetricEntity);

        userDAO.save(userEntity);

        if(userDAO.findByUsername(user.getUsername()) != null) return true;
        else return false;
    }
}

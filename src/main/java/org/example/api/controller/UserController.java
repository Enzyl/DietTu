package org.example.api.controller;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.api.dto.UserRegisterRequestDTO;
import org.example.business.service.UserService;
import org.example.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@AllArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping("/showUserProfile")
    public void showUserProfile(){
    }

    @GetMapping("/registerView")
    public String showRegisterView(){
        //guzik Zarejestruj
        return "userRegisterForm";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute UserRegisterRequestDTO userRegisterRequestDTO, HttpSession session){
        boolean isUserExist = userService.isUserExist(userRegisterRequestDTO.getUsername());
        if(isUserExist) return "loginView";

        User user = User.builder()
                .username(userRegisterRequestDTO.getUsername())
                .password(userRegisterRequestDTO.getPassword())
                .email(userRegisterRequestDTO.getEmail())
                //.userMetric(userRegisterRequestDTO.getUserMetric())
                .build();

        if(userService.createUser(user)) return "userLoggedInView";

        return "userRegisterForm";
    }

    @GetMapping("/loginView")
    public String showLoginUserView(){
        //guzik Zaloguj
        return "loginView";
    }

    //funkcja logowania
    @PostMapping("/login")
    public String loginUser(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            HttpSession session){
        boolean isUserValid = userService.verifyUser(username,password);
        session.setAttribute("username", username);
        session.setAttribute("userLoggedIn", isUserValid);
        if(!isUserValid){
            log.info("### Nie weszłeś bo coś spaprałeś ###");
            return "loginView";
        }
        log.info("### Udało się wbić, jest gites ###");
        return "userLoggedInView";
    }
}

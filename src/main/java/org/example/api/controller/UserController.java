package org.example.api.controller;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.business.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/register")
    public void register(){

    }


    @GetMapping("/loginView")
    public String showLoginUserView(){
    return "userLoginView";
    }
    @PostMapping("/login")
    public String loginUser(@RequestParam("username") String username,@RequestParam("password") String password){
        boolean isUserValid = userService.verifyUser(username,password);
        if(!isUserValid){
            return "userLoginView";
        }
        return "userLoggedInView";

    }
}

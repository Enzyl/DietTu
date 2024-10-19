package org.example.api.controller;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.business.service.UserService;
import org.springframework.stereotype.Controller;
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

    //TODO dodac sesje i inne paramy do stworzenia konta
    @GetMapping("/registerView")
    public String showRegisterView(@RequestParam("username") String username){
        boolean isUserExist = userService.isUserExist(username);

        if(isUserExist) return "loginView";
        return "registerView";
    }


    @GetMapping("/loginView")
    public String showLoginUserView(){
    return "userLoginView";
    }
    @PostMapping("/login")
    public String loginUser(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            HttpSession session
    ){
        boolean isUserValid = userService.verifyUser(username,password);
        if(!isUserValid){
            log.info("### Nie weszłeś bo coś spaprałeś ###");
            return "loginView";
        }

        log.info("### Udało się wbić, jest gites ###");
        return "userLoggedInView";

    }
}

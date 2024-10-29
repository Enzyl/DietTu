package org.example.api.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.api.dto.UserRegisterRequestDTO;
import org.example.business.service.UserService;
import org.example.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String showUserProfile(Model model, HttpSession session){
        return "userProfile";
    }

    @GetMapping("/registerView")
    public String showRegisterView(Model model){
        //guzik Zarejestruj
        model.addAttribute("userRegisterRequestDTO", new UserRegisterRequestDTO());
        return "userRegisterForm";
    }
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute UserRegisterRequestDTO userRegisterRequestDTO,
                           BindingResult result,
                           HttpSession session) {
        if (result.hasErrors()) {
            return "userRegisterForm"; // wróć do formularza, jeśli są błędy walidacji
        }

        boolean isUserExist = userService.isUserExist(userRegisterRequestDTO.getUsername());
        if(isUserExist) return "loginView";

        User user = User.builder()
                .username(userRegisterRequestDTO.getUsername())
                .password(userRegisterRequestDTO.getPassword())
                .email(userRegisterRequestDTO.getEmail())
                .build();

        if(userService.createUser(user)){
            return "userLoggedInView"; //tu
        }

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

        if(!userService.isUserExist(username)){
            log.info("### Ziomek nie istniejesz u nas lol ###");
            return "userRegisterForm";
        }

        boolean isUserValid = userService.checkIfUserCredentialsCorrect(username,password);
        session.setAttribute("username", username);
        session.setAttribute("userLoggedIn", isUserValid);
        if(!isUserValid){
            log.info("### Nie weszłeś bo coś spaprałeś ###");
            return "loginView";
        }
        log.info("### Udało się wbić, jest gites ###");
        return "userLoggedInView";
    }

    @PostMapping("/loggedInView")
    public String showUserLoggedInView(Model model, HttpSession session){
        model.addAttribute("username", session.getAttribute("username"));
        return "userLoggedInView";
    }



}

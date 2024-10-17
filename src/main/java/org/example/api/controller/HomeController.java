package org.example.api.controller;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
@Slf4j
@AllArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String showMainPage(){
        log.info("##### HomeController ### mainPageWorks");
        return "home";
    }

}

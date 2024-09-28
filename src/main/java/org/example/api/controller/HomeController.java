package org.example.api.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
@Slf4j
@AllArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String showMainPage(){
        log.info("##### HomeController ### mainPageWorks");
        return "homeView";
    }
}

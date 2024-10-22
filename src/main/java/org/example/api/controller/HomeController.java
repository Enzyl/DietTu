package org.example.api.controller;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.business.service.UserService;
import org.example.domain.ActivityLevel;
import org.example.domain.TargetActionLevel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.HashMap;

@Controller
@Slf4j
@AllArgsConstructor
public class HomeController {
    private final UserService userService;

    @GetMapping("/")
    public String showMainPage(Model model){
        model.addAttribute("activityLevels", ActivityLevel.values());
        model.addAttribute("targetActionLevels", TargetActionLevel.values());
        log.info("##### HomeController ### mainPageWorks");
        return "home";
    }

    @PostMapping("/calculateCalories")
    @ResponseBody
    public Map<String, Object> calculateCalories(@RequestBody Map<String, Object> requestData, HttpSession session) {
        log.info("### calculateCalories START");
        log.info("### requestData {}", requestData);

        // Pobieramy dane z requestData i parsujemy do odpowiednich typów
        String gender = (String) requestData.get("gender");
        int age = Integer.parseInt(requestData.get("age").toString());
        double weight = Double.parseDouble(requestData.get("weight").toString());
        double height = Double.parseDouble(requestData.get("height").toString());
        double activity = Double.parseDouble(requestData.get("activity").toString());
        int targetAction = Integer.parseInt(requestData.get("targetAction").toString());


        // Wyliczamy zapotrzebowanie kaloryczne
        double recommendedCalorieIntake = userService.calculateCPM(gender, age, weight, height, activity, targetAction);

        log.info("### gender {}  #age {} #weight {} #height {} #activity {} ###", gender, age, weight, height, activity);

        // Tworzymy odpowiedź w formacie JSON
        Map<String, Object> response = new HashMap<>();
        response.put("recommendedCalorieIntake", recommendedCalorieIntake);

        session.setAttribute("gender", gender);
        session.setAttribute("age", age);
        session.setAttribute("weight", weight);
        session.setAttribute("height", height);
        session.setAttribute("activity", activity);
        session.setAttribute("recommendedCalorieIntake", recommendedCalorieIntake);
        return response;
    }

    @GetMapping("/generateDiet")
    public String generateDiet(HttpSession session){
        log.info("##### HomeController ### generateDiet");
        boolean userLoggedIn =(boolean) session.getAttribute("userLoggedIn");
        log.info("##### HomeController ### userLoggedIn: {}", userLoggedIn);

        if (!userLoggedIn){
            // jeśli użytkownik jest niezalgoowany
            return "loginView";
        }

        return "home";
    }
}

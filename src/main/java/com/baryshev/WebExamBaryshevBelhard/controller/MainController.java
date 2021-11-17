package com.baryshev.WebExamBaryshevBelhard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping("/")
    public String home (Model model) {
        model.addAttribute("title","Главной странице");
        return "home";
    }
    @GetMapping("/Главная страница")
    public String query (Model model) {
        model.addAttribute("title","Главной странице");
        return "home";
    }

}
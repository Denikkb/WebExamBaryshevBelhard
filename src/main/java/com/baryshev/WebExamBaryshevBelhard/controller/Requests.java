package com.baryshev.WebExamBaryshevBelhard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Requests {

    @GetMapping ("/requests")
    public String requests (Model model){
        model.addAttribute("title", "requests");
        return "requests";
    }
}

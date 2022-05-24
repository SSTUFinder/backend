package com.diplom.sstufinder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {

    @GetMapping
    public String homePage(){
        return "index";
    }

    @GetMapping("/search")
    public String search(){
        return "search";
    }

    @GetMapping("/FAQ")
    public String faq(){
        return "faq";
    }

    @GetMapping("/map")
    public String map(){
        return "map";
    }

    @GetMapping("/position")
    public String position(){
        return "position";
    }


}

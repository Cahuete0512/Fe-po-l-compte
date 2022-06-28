package com.cahuete.FePolcompte.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParticipantController {


    @GetMapping("/")
    public String mainfunction(){
        return "hello";
    }
}

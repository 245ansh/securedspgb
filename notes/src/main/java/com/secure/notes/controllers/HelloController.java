package com.secure.notes.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
@GetMapping("/home")
    public String home(){
    return "IamGroot";
}
    @GetMapping("/contact")
    public String contact(){
        return "Contact";
    }
}

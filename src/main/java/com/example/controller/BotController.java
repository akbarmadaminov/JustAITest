package com.example.controller;

import com.example.service.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/callback")
public class PostEvent {

    @Autowired
    private SendMessage sendMessage;

    @PostMapping
    public String postEvent(@RequestBody String requestBody) {
        System.out.println("Received POST request with body: " + requestBody);
        return "Received POST request with body: " + requestBody;
    }
}

package com.example.userservice;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first-service")
public class WelcomController {
    @RequestMapping("/welcome")
    public String welcome(@RequestHeader("first-request")String header) {
        System.out.println(header);
        return "Welcome to the First Service";
    }
}

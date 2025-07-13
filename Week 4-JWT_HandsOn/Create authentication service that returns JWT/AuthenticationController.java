package com.cognizant.springlearnjwt.controller;

import com.cognizant.springlearnjwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(Authentication authentication) {
        String username = authentication.getName();
        String token = jwtUtil.generateToken(username);

        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return response;
    }
}

package com.cognizant.loan;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoanController {

    @GetMapping("/loans/{number}")
    public Map<String, Object> getLoanDetails(@PathVariable String number) {
        Map<String, Object> response = new HashMap<>();
        response.put("number", number);
        response.put("type", "car");
        response.put("loan", 400000);
        response.put("emi", 3258);
        response.put("tenure", 18);
        return response;
    }
}

package com.cognizant.account;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AccountController {

    @GetMapping("/accounts/{number}")
    public Map<String, Object> getAccountDetails(@PathVariable String number) {
        Map<String, Object> response = new HashMap<>();
        response.put("number", number);
        response.put("type", "savings");
        response.put("balance", 234343);
        return response;
    }
}

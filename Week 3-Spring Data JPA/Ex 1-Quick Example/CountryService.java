package com.cognizant.ormlearn.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import com.cognizant.ormlearn.model.Country;

@Service  // 🔥 This line is very important!
public class CountryService {

    public List<Country> getAllCountries() {
        List<Country> countries = new ArrayList<>();

        // Sample data — replace with DB fetch logic later
        Country country1 = new Country("IN", "India");
        Country country2 = new Country("US", "United States");

        countries.add(country1);
        countries.add(country2);

        return countries;
    }
}

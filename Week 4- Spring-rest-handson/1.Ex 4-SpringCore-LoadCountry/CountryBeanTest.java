package com.cognizant.spring_learn1;

import com.cognizant.springlearn1.Country;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CountryBeanTest {

    @Test
    public void testCountryBeanLoaded() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);
        assertEquals("IN", country.getCode());
        assertEquals("India", country.getName());
    }

    private void assertEquals(String in, String code) {
    }
}

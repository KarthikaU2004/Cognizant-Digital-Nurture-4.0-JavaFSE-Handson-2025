package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cognizant.springlearn.service.EmployeeService;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService service;

    @Test
    public void testGetAllEmployees() throws Exception {
        when(service.getAllEmployees()).thenReturn(
                Arrays.asList(new Employee(1, "Arun", "IT"))
        );

        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Arun"));
    }

    @Test
    public void testAddEmployee() throws Exception {
        Employee emp = new Employee(3, "Sita", "Finance");

        when(service.addEmployee(any(Employee.class))).thenReturn(emp);

        mockMvc.perform(post("/employees")
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(emp)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Sita"));
    }
}

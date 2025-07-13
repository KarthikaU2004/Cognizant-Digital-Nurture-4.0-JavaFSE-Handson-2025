package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private final Map<Integer, Employee> employeeMap = new HashMap<>();

    public EmployeeService() {
        employeeMap.put(1, new Employee(1, "Arun", "IT"));
        employeeMap.put(2, new Employee(2, "Bala", "HR"));
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeMap.values());
    }

    public Employee getEmployeeById(int id) {
        return employeeMap.get(id);
    }

    public Employee addEmployee(Employee employee) {
        employeeMap.put(employee.getId(), employee);
        return employee;
    }
}

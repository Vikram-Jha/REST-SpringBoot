package com.example.employee.service;

import java.util.List;
import java.util.Map;

import com.example.employee.entity.Employee;

public interface EmployeeService {
    public List<Employee> getAllEmployee();

    public Employee addEmployee(Employee employee);

    public Employee getEmployeeById(Integer id);

    public Employee updateEmployee(Integer id, Employee employee);

    public Map<String, Boolean> deleteEmployee(Integer id);
}

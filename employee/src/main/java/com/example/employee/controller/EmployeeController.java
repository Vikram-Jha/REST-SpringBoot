package com.example.employee.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class EmployeeController {
    @Autowired
    private EmployeeService empService;

    // Get all Employee
    @GetMapping("/employees")
    public List<Employee> getAllEmployee() {
        return this.empService.getAllEmployee();
    }

    // Add a employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return this.empService.addEmployee(employee);
    }

    // get Employee by employee id
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
        Employee employee = this.empService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    // Update Details of Employee
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        Employee emp = this.empService.updateEmployee(id, employee);
        return ResponseEntity.ok(emp);
    }

    // Delete Employee rest api
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Integer id) {
        Map<String, Boolean> response = this.empService.deleteEmployee(id);
        return ResponseEntity.ok(response);
    }
}
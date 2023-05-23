package com.example.employee.serviceImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.employee.entity.Employee;
import com.example.employee.repo.EmployeeRepo;
import com.example.employee.service.EmployeeService;
import com.example.employee.exception.ResourceNotFoundException;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
    @Autowired
    private EmployeeRepo empRepo;

    @Override
    public List<Employee> getAllEmployee() {
        return this.empRepo.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return this.empRepo.save(employee);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return this.empRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee Doesn't Exist with Id " + id));
    }

    @Override
    public Employee updateEmployee(Integer id, Employee employee) {
        Employee emp = this.empRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee Doesn't Exist with Id " + id));
        emp.setName(employee.getName());
        emp.setEmail(employee.getEmail());
        Employee updatedEmployee = this.empRepo.save(emp);
        return updatedEmployee;
    }

    @Override
    public Map<String, Boolean> deleteEmployee(Integer id) {
        Employee emp = this.empRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee Doesn't Exist with Id " + id));
        empRepo.delete(emp);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
package com.example.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.employee.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}

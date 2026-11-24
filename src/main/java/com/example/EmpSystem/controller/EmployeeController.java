package com.example.EmpSystem.controller;

import com.example.EmpSystem.dto.EmployeeDTO;
import com.example.EmpSystem.entity.Employee;
import com.example.EmpSystem.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;

    @PostMapping
    public Employee addEmployee(@Valid @RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return "employee deleted successfully";
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
            return employeeService.updateEmployee(id, employee);
    }
    @GetMapping("/{id}/dto")
    public EmployeeDTO getEmployeeDTOById(
            @PathVariable Long id) {

        return employeeService.getEmployeeDTOById(id);
    }

    @PostMapping("/dto")
    public EmployeeDTO addEmployeeDTO(@Valid @RequestBody EmployeeDTO dto) {

        return employeeService.saveEmployeeDTO(dto);
    }
    @GetMapping("/pagination")
    public Page<Employee> getEmployeesWithPagination(
            @RequestParam int page,
            @RequestParam int size) {

        return employeeService.getEmployeesWithPagination(page, size);
    }

    @GetMapping("/sort")
    public List<Employee> getEmployeesSorted(
            @RequestParam String field) {

        return employeeService.getEmployeesSorted(field);
    }

    @GetMapping("/pagination-sort")
    public Page<Employee> getEmployeesWithPaginationAndSorting(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String field) {

        return employeeService
                .getEmployeesWithPaginationAndSorting(page, size, field);
    }

}

package com.example.EmpSystem.service;

import com.example.EmpSystem.dto.EmployeeDTO;
import com.example.EmpSystem.entity.Employee;
import com.example.EmpSystem.exception.EmployeeNotFoundException;
import com.example.EmpSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {

        return employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee not found with id " + id));
    }
    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(Long id, Employee updateEmployee) {
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);
        if (existingEmployee != null) {

            existingEmployee.setName(updateEmployee.getName());
            existingEmployee.setEmail(updateEmployee.getEmail());
            existingEmployee.setDepartment(updateEmployee.getDepartment());
            existingEmployee.setSalary(updateEmployee.getSalary());

            return employeeRepository.save(existingEmployee);
        }
        return null;
    }
    public Employee getEmployeeByEmail(String email){
        return employeeRepository.findByEmail(email);
    }
    public EmployeeDTO getEmployeeDTOById(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee not found with id " + id));

        return convertToDTO(employee);
    }

    public Employee convertToEntity(EmployeeDTO dto) {

        Employee employee = new Employee();

        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(dto.getDepartment());
        employee.setSalary(dto.getSalary());

        return employee;
    }

    public EmployeeDTO convertToDTO(Employee employee) {

        EmployeeDTO dto = new EmployeeDTO();

        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setEmail(employee.getEmail());
        dto.setDepartment(employee.getDepartment());
        dto.setSalary(employee.getSalary());

        return dto;
    }

    public EmployeeDTO saveEmployeeDTO(EmployeeDTO dto) {

        Employee employee = convertToEntity(dto);

        Employee savedEmployee = employeeRepository.save(employee);

        return convertToDTO(savedEmployee);
    }

    public Page<Employee> getEmployeesWithPagination(
            int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return employeeRepository.findAll(pageable);
    }

    public List<Employee> getEmployeesSorted(String field) {

        return employeeRepository.findAll(
                Sort.by(Sort.Direction.ASC, field)
        );
    }

    public Page<Employee> getEmployeesWithPaginationAndSorting(
            int page, int size, String field) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(Sort.Direction.ASC, field)
        );

        return employeeRepository.findAll(pageable);
    }
}

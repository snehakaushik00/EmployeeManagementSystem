package com.example.EmpSystem.service;

import com.example.EmpSystem.entity.Employee;
import com.example.EmpSystem.entity.LeaveRequest;
import com.example.EmpSystem.exception.EmployeeNotFoundException;
import com.example.EmpSystem.exception.LeaveNotFoundException;
import com.example.EmpSystem.repository.EmployeeRepository;
import com.example.EmpSystem.repository.LeaveRequestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LeaveRequestService {

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;

    @Autowired
    private EmployeeRepository employeeRepository;


    // Apply Leave
    @Transactional
    public LeaveRequest applyLeave(Long employeeId,
                                   LeaveRequest leaveRequest) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(
                        "Employee not found with id " + employeeId));

        leaveRequest.setEmployee(employee);

        leaveRequest.setStatus("PENDING");

        return leaveRequestRepository.save(leaveRequest);
    }


    // Get All Leaves
    public List<LeaveRequest> getAllLeaves() {

        return leaveRequestRepository.findAll();
    }


    // Approve Leave
    @Transactional
    public LeaveRequest approveLeave(Long leaveId) {

        LeaveRequest leave = leaveRequestRepository.findById(leaveId)
                .orElseThrow(() -> new LeaveNotFoundException(
                        "Leave not found with id " + leaveId));

        leave.setStatus("APPROVED");

        return leaveRequestRepository.save(leave);
    }


    // Reject Leave
    @Transactional
    public LeaveRequest rejectLeave(Long leaveId) {

        LeaveRequest leave = leaveRequestRepository.findById(leaveId)
                .orElseThrow(() -> new LeaveNotFoundException(
                        "Leave not found with id " + leaveId));

        leave.setStatus("REJECTED");

        return leaveRequestRepository.save(leave);
    }


    // Get Leaves By Employee ID
    public List<LeaveRequest> getLeaveByEmployeeId(Long employeeId) {

        return leaveRequestRepository.findByEmployeeId(employeeId);
    }


    // Get Leaves By Status
    public List<LeaveRequest> getLeaveByStatus(String status) {

        return leaveRequestRepository.findByStatus(status);
    }

}
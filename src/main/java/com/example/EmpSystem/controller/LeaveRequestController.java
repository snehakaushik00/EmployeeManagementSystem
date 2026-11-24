package com.example.EmpSystem.controller;


import com.example.EmpSystem.entity.LeaveRequest;
import com.example.EmpSystem.service.LeaveRequestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leaves")
public class LeaveRequestController {

    @Autowired
    private LeaveRequestService leaveRequestService;

    @PostMapping("/apply/{employeeId}")
    public LeaveRequest applyLeave(
            @PathVariable Long employeeId,
            @Valid @RequestBody LeaveRequest leaveRequest) {

        return leaveRequestService.applyLeave(employeeId, leaveRequest);

    }

    @PreAuthorize("hasRole('MANAGER')")
    @GetMapping
    public List<LeaveRequest> getAllLeaves(){
        return leaveRequestService.getAllLeaves();
    }

    @PreAuthorize("hasRole('MANAGER')")
    @PutMapping("/approve/{leaveId}")
    public LeaveRequest approveLeave(
            @PathVariable Long leaveId){

        return leaveRequestService.approveLeave(leaveId);
    }

    @PreAuthorize("hasRole('MANAGER')")
    @PutMapping("/reject/{leaveId}")
    public LeaveRequest rejectLeave(
            @PathVariable Long leaveId){
        return leaveRequestService.rejectLeave(leaveId);
    }

    @GetMapping("/employee/{employeeId}")
    public List<LeaveRequest> getLeavesByEmployeeId(
            @PathVariable Long employeeId){
        return leaveRequestService.getLeaveByEmployeeId(employeeId);
    }

    @GetMapping("/status/{status}")
    public List<LeaveRequest> getLeavesByStatus(
            @PathVariable String status){
        return leaveRequestService.getLeaveByStatus(status);
    }
}

package com.adt.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adt.hrms.model.LeaveRequestModel;
import com.adt.hrms.service.LeaveRequestService;



@RestController
@RequestMapping("/leave")
public class LeaveController {

	@Autowired
	private LeaveRequestService leaveRequestService;

	@PostMapping("/leaveRequest")
	public ResponseEntity<String> saveLeaveRequest(@RequestBody LeaveRequestModel lr) {
		return new ResponseEntity<>(leaveRequestService.saveLeaveRequest(lr), HttpStatus.OK);

	}

	@GetMapping("/getLeaveDetails")
	public ResponseEntity<List<LeaveRequestModel>> getLeaveDetails() {
		return new ResponseEntity<>(leaveRequestService.getLeaveDetails(), HttpStatus.OK);
	}

	@GetMapping("getLeaveByEmpId/{empid}")
	public ResponseEntity<LeaveRequestModel> getLeaveDetailsByEmpId(@PathVariable("empid") int empid) {
		return new ResponseEntity<>(leaveRequestService.getLeaveDetailsByEmpId(empid), HttpStatus.OK);
	}

}

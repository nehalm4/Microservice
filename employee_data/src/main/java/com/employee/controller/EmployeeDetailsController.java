package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.pojo.EmployeeDetails;
import com.employee.service.EmployeeDetailsService;

@RestController
@RequestMapping("/employee")
public class EmployeeDetailsController {

	@Autowired
	private EmployeeDetailsService detailsService;

	@PostMapping("/save")
	public ResponseEntity<String> saveEmployeeDetails(@RequestBody EmployeeDetails employeeDetails) {
		detailsService.saveEmployeeDetails(employeeDetails);
		return ResponseEntity.ok("Employee Details Saved");
	}

	@GetMapping("/list")
	public ResponseEntity<List<EmployeeDetails>> listEmployeeDetails() {
		return ResponseEntity.ok(detailsService.listEmployeeDetails());
	}

}

package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.pojo.EmployeeDetails;
import com.employee.repository.EmployeeDetailsRepository;

@Service
public class EmployeeDetailsService {

	@Autowired
	private EmployeeDetailsRepository detailsRepository;
	
	
	public void saveEmployeeDetails(EmployeeDetails employeeDetails) {
		detailsRepository.save(employeeDetails);
	}
	
	public List<EmployeeDetails> listEmployeeDetails() {
		return detailsRepository.findAll();
	}
}

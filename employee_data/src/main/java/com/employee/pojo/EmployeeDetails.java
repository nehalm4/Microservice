package com.employee.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "employee_details")
public class EmployeeDetails {

	@Id
	private Integer employeeId;
	private String employeeName;
}

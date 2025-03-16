package com.careeropenings.CareerOpenings.DTO;

import lombok.Data;

@Data
public class CandidateDTO {
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String jobTitle;
	private String employmentType;
	private String location;
	private String appliedDate;
	private String startedate;
	private String enddate;

	public CandidateDTO(String firstName, String lastName, String email, String phone, String jobTitle,
			String employmentType, String location, String appliedDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.jobTitle = jobTitle;
		this.employmentType = employmentType;
		this.location = location;
		this.appliedDate = appliedDate;
	}
}

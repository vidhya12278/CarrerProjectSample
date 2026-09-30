package com.careeropenings.CareerOpenings.Case;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.careeropenings.CareerOpenings.Controller.GetCandidateDetailsController;
import com.careeropenings.CareerOpenings.Entity.SaveCandidateDetails;
import com.careeropenings.CareerOpenings.Service.GetCandidateDetailsService;

@ExtendWith(MockitoExtension.class)
class CareerOpeningServiceTest {

	@Mock
	private GetCandidateDetailsService service;

	@InjectMocks
	private GetCandidateDetailsController controller;

	// Positive Test Case
	@Test
	void shouldReturnCandidateWhenValidIdProvided() {

		// Arrange
		SaveCandidateDetails candidate = new SaveCandidateDetails();

		candidate.setCandidateId(101L);
		candidate.setFirstName("Alice");

		when(service.getCandidateDetails(101L)).thenReturn(candidate);

		// Act
		ResponseEntity<?> response = controller.getCandidateDetails(101L);

		// Assert
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(candidate, response.getBody());

		verify(service).getCandidateDetails(101L);
	}

	// Positive Test Case - Verify Service Call
	@Test
	void shouldCallServiceOnlyOnce() {

		// Arrange
		SaveCandidateDetails candidate = new SaveCandidateDetails();

		when(service.getCandidateDetails(101L)).thenReturn(candidate);

		// Act
		controller.getCandidateDetails(101L);

		// Assert
		verify(service).getCandidateDetails(101L);
	}

	// Negative Test Case - Service Exception
	@Test
	void shouldReturnInternalServerErrorWhenServiceFails() {

		// Arrange
		when(service.getCandidateDetails(101L)).thenThrow(new RuntimeException("Database error"));

		// Act
		ResponseEntity<?> response = controller.getCandidateDetails(101L);

		// Assert
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());

		verify(service).getCandidateDetails(101L);
	}

}
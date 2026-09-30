package com.careeropenings.CareerOpenings.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.careeropenings.CareerOpenings.Response.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CandidateNotFoundException.class)
	public ResponseEntity<ErrorResponse> CandidateNotFoundException(CandidateNotFoundException ex,
			HttpServletRequest request) {

		ErrorResponse errorResponse = new ErrorResponse(
				LocalDateTime.now(), 
				HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND.getReasonPhrase(), 
				ex.getMessage(), 
				request.getRequestURI());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}
}

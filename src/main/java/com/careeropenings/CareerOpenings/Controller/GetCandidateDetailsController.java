package com.careeropenings.CareerOpenings.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.careeropenings.CareerOpenings.Entity.SaveCandidateDetails;
import com.careeropenings.CareerOpenings.Service.GetCandidateDetailsService;

@RestController
public class GetCandidateDetailsController {

	private GetCandidateDetailsService getCandidateDetailsService;

	public GetCandidateDetailsController(GetCandidateDetailsService getCandidateDetailsService) {
		this.getCandidateDetailsService = getCandidateDetailsService;
	}

	@GetMapping("/getCandidateDetails/{id}")
	public ResponseEntity<SaveCandidateDetails> getCandidateDetails(@PathVariable Long id) {
		SaveCandidateDetails candidateDetails = getCandidateDetailsService.getCandidateDetails(id);
		return ResponseEntity.ok(candidateDetails);
	}
}

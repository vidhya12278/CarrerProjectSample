package com.careeropenings.CareerOpenings.Controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.careeropenings.CareerOpenings.DTO.CandidateDTO;
import com.careeropenings.CareerOpenings.Service.RetrieveAllCandidatesService;

@RestController
public class RetrieveAllCandidateController {

	private final RetrieveAllCandidatesService retrieveService;

	public RetrieveAllCandidateController(RetrieveAllCandidatesService retrieveService) {
		this.retrieveService = retrieveService;
	}

	@PostMapping("/allCandidate")
	public Map<String, Object> retrieveAllCandidates() {
		Map<String, Object> allCandidate = retrieveService.retrieveAllCandidate();
		return allCandidate;
	}

	@PostMapping("/filterCandidate")
	public Map<String, Object> filterCandidates(@RequestBody CandidateDTO candidateDTO) {
		Map<String, Object> filterData = retrieveService.filterCandidate(candidateDTO);
		return filterData;
	}
}

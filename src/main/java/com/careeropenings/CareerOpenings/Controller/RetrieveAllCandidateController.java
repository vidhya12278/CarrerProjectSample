package com.careeropenings.CareerOpenings.Controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.careeropenings.CareerOpenings.DTO.CandidateDTO;
import com.careeropenings.CareerOpenings.Service.RetrieveAllCandidatesService;

@RestController
public class RetrieveAllCandidateController {
	private static final Logger logger = LoggerFactory.getLogger(RetrieveAllCandidateController.class);
	
	private final RetrieveAllCandidatesService retrieveService;

	public RetrieveAllCandidateController(RetrieveAllCandidatesService retrieveService) {
		this.retrieveService = retrieveService;
	}

	@PostMapping("/allCandidate")
	public Map<String, Object> retrieveAllCandidates() {
		logger.info("RetrieveAllCandidateController starts the retrieveAllCandidates service");
		Map<String, Object> allCandidate = retrieveService.retrieveAllCandidate();
		logger.info("RetrieveAllCandidateController ends the retrieveAllCandidates service" + allCandidate);
		return allCandidate;
	}

	@PostMapping("/filterCandidate")
	public Map<String, Object> filterCandidates(@RequestBody CandidateDTO candidateDTO) {
		Map<String, Object> filterData = retrieveService.filterCandidate(candidateDTO);
		return filterData;
	}
}

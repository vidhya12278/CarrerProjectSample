package com.careeropenings.CareerOpenings.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.careeropenings.CareerOpenings.Entity.SaveCandidateDetails;
import com.careeropenings.CareerOpenings.Service.SaveCandidateService;

@RestController
public class SaveCandidateController {

	private final SaveCandidateService saveCandidateService;

	public SaveCandidateController(SaveCandidateService saveCandidateService) {
		this.saveCandidateService = saveCandidateService;
	}

	@PostMapping("/saveCandidates")
	public Map<String, String> saveCandidate(@RequestBody List<SaveCandidateDetails> saveDetails) {
		Map<String, String> saveCandidateDetail = saveCandidateService.saveCandidateDetai(saveDetails);
		return saveCandidateDetail;
	}
}

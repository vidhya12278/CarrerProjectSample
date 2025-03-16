package com.careeropenings.CareerOpenings.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.careeropenings.CareerOpenings.Entity.SaveCandidateDetails;
import com.careeropenings.CareerOpenings.Repo.SaveCandidateRep;

@Service
public class SaveCandidateService {

	private final SaveCandidateRep saveRepo;

	public SaveCandidateService(SaveCandidateRep saveRepo) {
		this.saveRepo = saveRepo;
	}

	public Map<String,String> saveCandidateDetai(List<SaveCandidateDetails> saveDetails) {
		List<SaveCandidateDetails> collect = saveDetails.stream().map(saveRepo::save).collect(Collectors.toList());
		return collect.isEmpty() ? Map.of("error", "failed to insert") : Map.of("success", "saved successfully");
	}
}

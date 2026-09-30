package com.careeropenings.CareerOpenings.Service;

import org.springframework.stereotype.Service;

import com.careeropenings.CareerOpenings.Entity.SaveCandidateDetails;
import com.careeropenings.CareerOpenings.Exception.CandidateNotFoundException;
import com.careeropenings.CareerOpenings.Repo.GetCandidateDetailsRepo;

@Service
public class GetCandidateDetailsService {

	private GetCandidateDetailsRepo getCandidateRepo;

	public GetCandidateDetailsService(GetCandidateDetailsRepo getCandidateRepo) {
		this.getCandidateRepo = getCandidateRepo;
	}

	public SaveCandidateDetails getCandidateDetails(Long candidateId) {
//		return getCandidateRepo.findById(candidateId)
//				.orElseThrow(() -> new RuntimeException("Candidate details not found"));

		return getCandidateRepo.findById(candidateId).orElseThrow(
				() -> new CandidateNotFoundException("Candidate details not found for ID: " + candidateId));
	}
}

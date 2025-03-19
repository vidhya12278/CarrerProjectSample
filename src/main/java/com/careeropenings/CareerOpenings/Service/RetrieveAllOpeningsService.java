package com.careeropenings.CareerOpenings.Service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.careeropenings.CareerOpenings.Entity.RoleDetails;
import com.careeropenings.CareerOpenings.Repo.RoleRepo;

@Service
public class RetrieveAllOpeningsService {
	private static final Logger logger = LoggerFactory.getLogger(RetrieveAllOpeningsService.class);

	private final RoleRepo roleRepo;

	public RetrieveAllOpeningsService(RoleRepo roleRepo) {
		this.roleRepo = roleRepo;
	}

	public Map<String, Object> getAllOpenings() {

		List<RoleDetails> allOpenings = roleRepo.getAllOpenings();

		logger.info("RetrieveAllOpeningsService data size : " + allOpenings.size());

		return Map.of("StatusCode", allOpenings.isEmpty() ? "0" : "1", "Message",
				allOpenings.isEmpty() ? "Failure" : "Success", "allOpenings",
				allOpenings.isEmpty() ? "No Records Found" : allOpenings);
	}
}

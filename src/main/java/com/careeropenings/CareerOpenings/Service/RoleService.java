package com.careeropenings.CareerOpenings.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.careeropenings.CareerOpenings.Entity.RoleDetails;
import com.careeropenings.CareerOpenings.Repo.RoleRepo;

@Service
public class RoleService {
	
	private static final Logger logger = LoggerFactory.getLogger(RoleService.class);
	
	private final RoleRepo roleRepo;

	public RoleService(RoleRepo roleRepo) {
		this.roleRepo = roleRepo;
	}

	public Map<String, Object> saveRequirement(List<RoleDetails> roleDetails) {
		List<RoleDetails> saveReq = roleDetails.stream().map(roleRepo::save).collect(Collectors.toList());

		return Map.of("Statuscode", saveReq.isEmpty() ? "0" : "1", "Message", saveReq.isEmpty() ? "Failure" : "Success",
				"unPublishedDetails", saveReq.isEmpty() ? "No Records Found" : roleRepo.findAllUnpublished());

	}
}

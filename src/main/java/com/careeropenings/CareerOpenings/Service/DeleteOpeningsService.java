package com.careeropenings.CareerOpenings.Service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.careeropenings.CareerOpenings.DTO.RoleRequestDTO;
import com.careeropenings.CareerOpenings.Repo.RoleRepo;

@Service
public class DeleteOpeningsService {
	private static final Logger logger = LoggerFactory.getLogger(DeleteOpeningsService.class);

	private final RoleRepo roleRepo;

	public DeleteOpeningsService(RoleRepo roleRepo) {
		this.roleRepo = roleRepo;
	}

	public Map<String, Object> deleteOpenings(RoleRequestDTO roleRequest) {
		String detailId = roleRequest.getDetailId();
		String deleteFlag = roleRequest.getDeleteFlag();

		int deletedRows = ("Y".equalsIgnoreCase(deleteFlag)) ? roleRepo.deleteOpenings(detailId)
				: roleRepo.deleteMultiOpenings();

		logger.info("DeleteOpeningsService deletedRows response: {}", deletedRows);

		return Map.of("status", deletedRows > 0 ? "success" : "failure", "message",
				deletedRows > 0 ? "Deleted Successfully" : "No records deleted", "deletedRows", deletedRows);

	}

}

package com.careeropenings.CareerOpenings.Service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.careeropenings.CareerOpenings.DTO.RoleRequestDTO;
import com.careeropenings.CareerOpenings.Repo.RoleRepo;

import jakarta.transaction.Transactional;

@Service
public class UpdatePublishService {

	private static final Logger logger = LoggerFactory.getLogger(UpdatePublishService.class);
	private final RoleRepo roleRepo;

	public UpdatePublishService(RoleRepo roleRepo) {
		this.roleRepo = roleRepo;
	}

	@Transactional
	public Map<String, String> updatePublish(RoleRequestDTO roleRequest) {

		String detailId = roleRequest.getDetailId();
		String enableFlag = roleRequest.getEnableFlag();

		logger.info("UpdatePublishService request detailId: {}", detailId + "enableFlag: {} " + enableFlag);

		int updatedRows = ("Y".equalsIgnoreCase(enableFlag)) ? roleRepo.publishWhenSingleRequest(detailId)
				: roleRepo.publishWhenMultipleRequest();

		roleRepo.flush();
		logger.info("UpdatePublishService updated rows: {}", updatedRows);

		return Map.of("statusCode", updatedRows > 0 ? "0" : "1", "status", updatedRows > 0 ? "success" : "failure",
				"message", updatedRows > 0 ? "Published Successfully" : "No records updated");
	}
}

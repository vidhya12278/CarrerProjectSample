package com.careeropenings.CareerOpenings.Controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.careeropenings.CareerOpenings.DTO.RoleRequestDTO;
import com.careeropenings.CareerOpenings.Service.UpdatePublishService;

@RestController
public class PublishController {

	private final UpdatePublishService updateService;

	public PublishController(UpdatePublishService updateService) {
		this.updateService = updateService;
	}

	@PostMapping("/enablePublish")
	public Map<String, String> enableRequirement(@RequestBody RoleRequestDTO roleRequest) {
		Map<String, String> updatePublish = updateService.updatePublish(roleRequest);
		return updatePublish;
	}
}

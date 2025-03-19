package com.careeropenings.CareerOpenings.Controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careeropenings.CareerOpenings.Service.RetrieveAllOpeningsService;

@RestController
public class RetrieveAllOpeningsController {

	private final RetrieveAllOpeningsService openingsService;

	public RetrieveAllOpeningsController(RetrieveAllOpeningsService openingsService) {
		this.openingsService = openingsService;
	}

	@PostMapping("/allOpenings")
	public Map<String, Object> allOpenings() {
		Map<String, Object> allOpenings = openingsService.getAllOpenings();
		return allOpenings;
	}
}

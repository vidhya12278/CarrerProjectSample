package com.careeropenings.CareerOpenings.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careeropenings.CareerOpenings.Entity.CareerMaster;
import com.careeropenings.CareerOpenings.Service.CareerMasterService;

@RestController
public class CareerMasterController {

	private final CareerMasterService careerService;

	public CareerMasterController(CareerMasterService careerService) {
		this.careerService = careerService;
	}

	@PostMapping("/careerMaster")
	public Map<String, List<CareerMaster>> getCareerDetails() {
		Map<String, List<CareerMaster>> careerContent = careerService.getCareerContent();
		return careerContent;
	}

}

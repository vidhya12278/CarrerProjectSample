package com.careeropenings.CareerOpenings.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careeropenings.CareerOpenings.Entity.CareerMaster;
import com.careeropenings.CareerOpenings.Repo.CareerMasterRepo;

@Service
public class CareerMasterService {

	private final CareerMasterRepo careerRepo;

	@Autowired
	public CareerMasterService(CareerMasterRepo careerRepo) {
		this.careerRepo = careerRepo;
	}

	public Map<String, List<CareerMaster>> getCareerContent() {
		return Collections.singletonMap("getCareerDetails", careerRepo.findAll().stream().collect(Collectors.toList()));
	}
}

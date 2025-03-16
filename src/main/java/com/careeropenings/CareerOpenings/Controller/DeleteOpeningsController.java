package com.careeropenings.CareerOpenings.Controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.careeropenings.CareerOpenings.DTO.RoleRequestDTO;
import com.careeropenings.CareerOpenings.Service.DeleteOpeningsService;

@RestController
public class DeleteOpeningsController {

	private final DeleteOpeningsService deleteOpening;

	public DeleteOpeningsController(DeleteOpeningsService deleteOpening) {
		this.deleteOpening = deleteOpening;
	}

	@PostMapping("/deleteOpenings")
	public Map<String, Object> deleteOpenings(@RequestBody RoleRequestDTO roleDTO) {
		Map<String, Object> deleteOpenings = deleteOpening.deleteOpenings(roleDTO);
		return deleteOpenings;
	}
}

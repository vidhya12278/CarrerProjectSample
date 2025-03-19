package com.careeropenings.CareerOpenings.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.careeropenings.CareerOpenings.Entity.RoleDetails;
import com.careeropenings.CareerOpenings.Service.RoleService;

@RestController
public class RoleController {

	private final RoleService roleService;

	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}

	@PostMapping("/saveDetails")
	public ResponseEntity<Map<String, Object>> insertRoles(
			@RequestBody List<RoleDetails> roleDetails) {
		Map<String, Object> savedRoles = roleService.saveRequirement(roleDetails);
		return ResponseEntity.ok(savedRoles);
	}
}

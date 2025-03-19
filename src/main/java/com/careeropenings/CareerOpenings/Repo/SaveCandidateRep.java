package com.careeropenings.CareerOpenings.Repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.careeropenings.CareerOpenings.Entity.SaveCandidateDetails;

public interface SaveCandidateRep extends JpaRepository<SaveCandidateDetails, Long> {

	// month data
	@Query(value = "SELECT cd.first_name, cd.last_name, cd.email, cd.mobile_number, "
			+ "cd.position_applied, cd.preferred_employ_type, cd.preferred_work_location, "
			+ "cd.inserted_date AS appliedDate " + "FROM candidate_details cd "
			+ "INNER JOIN testrole_details tr ON cd.rolecode = tr.rolecode " + "WHERE tr.publish = '1' "
			+ "AND DATE(cd.inserted_date) BETWEEN :startDate AND :endDate "
			+ "ORDER BY cd.inserted_date DESC", nativeQuery = true)
	List<Object[]> getAppliedCandidatesData(@Param("startDate") LocalDate startDate,
			@Param("endDate") LocalDate endDate);

	// filter
	@Query(value = "SELECT cd.first_name, cd.last_name, cd.email, cd.mobile_number, "
			+ "cd.position_applied, cd.preferred_employ_type, cd.preferred_work_location, "
			+ "cd.inserted_date AS appliedDate FROM candidate_details cd "
			+ "INNER JOIN testrole_details tr ON cd.rolecode = tr.rolecode " + "WHERE tr.publish = '1' "
			+ "AND DATE(cd.inserted_date) BETWEEN :startDate AND :endDate "
			+ "ORDER BY cd.inserted_date DESC", nativeQuery = true)
	List<Object[]> filterCandidatesData(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}

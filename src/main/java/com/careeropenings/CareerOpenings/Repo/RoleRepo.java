package com.careeropenings.CareerOpenings.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.careeropenings.CareerOpenings.Entity.RoleDetails;

import jakarta.transaction.Transactional;

public interface RoleRepo extends JpaRepository<RoleDetails, Long> {

	@Query("SELECT new com.careeropenings.CareerOpenings.Entity.RoleDetails( "
			+ "ts.detailId, ts.summary, ts.keyResponsibilities, ts.requiredQualification, "
			+ "ts.skills, ts.work_experience, ts.lpa, ts.publish, ts.inserteddate, ts.publisheddate, tr) "
			+ "FROM RoleDetails ts INNER JOIN ts.roleModel tr "
			+ "WHERE ts.publish = '0' ORDER BY ts.inserteddate DESC")
	List<RoleDetails> findAllUnpublished();

	@Transactional
	@Modifying
	@Query("UPDATE RoleDetails t SET t.publish = '1', publisheddate = CURRENT_TIMESTAMP WHERE t.detailId = :detailId")
	int publishWhenSingleRequest(@Param("detailId") String detailId);

	@Transactional
	@Modifying
	@Query("UPDATE RoleDetails t SET t.publish = '1'")
	int publishWhenMultipleRequest();

	@Query(value = "SELECT * FROM testrole_details where publish='1'", nativeQuery = true)
	List<RoleDetails> getAllOpenings();

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM testrole_details WHERE DETAIL_ID = :detailId", nativeQuery = true)
	int deleteOpenings(@Param("detailId") String detailId);

	@Transactional
	@Modifying
	@Query(value = "delete FROM testrole_details", nativeQuery = true)
	int deleteMultiOpenings();
}

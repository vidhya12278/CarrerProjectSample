package com.careeropenings.CareerOpenings.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.careeropenings.CareerOpenings.Entity.SaveCandidateDetails;

public interface GetCandidateDetailsRepo extends JpaRepository<SaveCandidateDetails,Long>{

}

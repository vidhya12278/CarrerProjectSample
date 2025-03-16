package com.careeropenings.CareerOpenings.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "candidate_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "candidate_seq", sequenceName = "CANDIDATE_SEQ", allocationSize = 1)
public class SaveCandidateDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long candidateId;

	private String firstName;
	private String lastName;
	private String email;
	private String mobileNumber;
	private String positionApplied;
	private String preferredEmployType;
	private String preferredWorkLocation;

	@Column(name = "insertedDate", columnDefinition = "TIMESTAMP")
	private LocalDateTime insertedDate;
	
	@ManyToOne
    @JoinColumn(name = "rolecode", referencedColumnName = "rolecode", nullable = false) 
    private RoleModel roleModel;

	@PrePersist
	protected void onCreate() {
		this.insertedDate = LocalDateTime.now();
	}
}

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
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "testrole_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long detailId;

	private String summary;
	private String keyResponsibilities;
	private String requiredQualification;
	private String skills;
	private String work_experience;
	private String lpa;
	private String publish;

	@Column(name = "inserteddate", columnDefinition = "TIMESTAMP")
	private LocalDateTime inserteddate;

	@Column(name = "publisheddate", columnDefinition = "TIMESTAMP")
	private LocalDateTime publisheddate;

	@ManyToOne
	@JoinColumn(name = "rolecode", referencedColumnName = "rolecode")
	private RoleModel roleModel;

	@PrePersist
	protected void onCreate() {
		this.inserteddate = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		if ("1".equals(this.publish != null ? this.publish : "0") && this.publisheddate == null) {
			this.publisheddate = LocalDateTime.now();
		}
	}

	@Override
	public String toString() {
		return "RoleDetails {" + "detailId=" + detailId + ", summary='" + summary + '\'' + ", keyResponsibilities='"
				+ keyResponsibilities + '\'' + ", requiredQualification='" + requiredQualification + '\'' + ", skills='"
				+ skills + '\'' + ", work_experience='" + work_experience + '\'' + ", lpa='" + lpa + '\''
				+ ", publish='" + publish + '\'' + ", inserteddate=" + inserteddate + ", publisheddate=" + publisheddate
				+ ", roleModel=" + (roleModel != null ? roleModel.getRolename() : "null") + '}';
	}
}

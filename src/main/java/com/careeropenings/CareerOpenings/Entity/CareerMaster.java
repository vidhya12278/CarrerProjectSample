package com.careeropenings.CareerOpenings.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "career_information")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CareerMaster {
	
	@Id
    private String description;

}

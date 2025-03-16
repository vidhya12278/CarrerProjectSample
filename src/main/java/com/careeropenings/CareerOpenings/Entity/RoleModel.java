package com.careeropenings.CareerOpenings.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "testrole")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleModel {

    @Id
    private String rolecode;

    private String rolename;

    @OneToMany(mappedBy = "roleModel", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore 
    private List<RoleDetails> roleDetails;
}

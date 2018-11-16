package com.condominiummanagerapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

@Entity
public class Condominium {
	
	@Id
	@SequenceGenerator(name = "condominium_seq", sequenceName = "condominium_seq", allocationSize = 1 )
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "condominium_seq")
	private Long id;
	
	@NotBlank
	private String name;
	
	private String description;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}

package com.condominiummanagerapi.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "condominiumareas")
public class CondominiumArea {
	
	@Id
	@SequenceGenerator(name = "condominiumareas_seq", sequenceName = "condominiumareas_seq", allocationSize = 1 )
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "condominiumareas_seq")
	private Long id;
	
	@NotNull
	@Size(min = 2, max = 30)
	private String description;
	
	@Enumerated(EnumType.STRING)
	private TypeCondominiumArea type;
	
	@ManyToOne
	@JoinColumn(name = "id_condominium")
	private Condominium condominium;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TypeCondominiumArea getType() {
		return type;
	}

	public void setType(TypeCondominiumArea type) {
		this.type = type;
	}

	public Condominium getCondominium() {
		return condominium;
	}

	public void setCondominium(Condominium condominium) {
		this.condominium = condominium;
	}
}
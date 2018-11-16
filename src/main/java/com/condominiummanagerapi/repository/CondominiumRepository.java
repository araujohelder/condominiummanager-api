package com.condominiummanagerapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.condominiummanagerapi.model.Condominium;

public interface CondominiumRepository extends JpaRepository<Condominium, Long> {
	
	 public List<Condominium> findByName(String name);

}

package com.condominiummanagerapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.condominiummanagerapi.model.Condominium;
import com.condominiummanagerapi.repository.CondominiumRepository;
import com.condominiummanagerapi.repository.condominium.filter.CondominiumFilter;


@Service
public class CondominiumService {
	
	@Autowired
	private CondominiumRepository condominiumRepository;
	
	public Condominium findByid(Long id) {
		Optional<Condominium> Condominium = condominiumRepository.findById(id);
		if (Condominium.isPresent() ) {
			return Condominium.get();
		}
		throw new EmptyResultDataAccessException(1);
	}
	
	public List<Condominium> findAll() {
		 return  condominiumRepository.findAll();
	}
	
	public List<Condominium> search(CondominiumFilter CondominiumFilter) {
		List<Condominium> Condominiums = null;
		if (CondominiumFilter.getName() != null) {
			Condominiums = condominiumRepository.findByName(CondominiumFilter.getName());
			return Condominiums;
		}
		Condominiums = condominiumRepository.findAll();
		return Condominiums;
	} 
	
	public void delete(Long id) {
		Condominium Condominium = this.findByid(id);
		condominiumRepository.delete(Condominium);
	}

	public Condominium save(Condominium Condominium)  {
		return condominiumRepository.save(Condominium);
	}

	public Condominium update(Long id, Condominium Condominium) {
		Condominium CondominiumReturn = this.findByid(id);
		BeanUtils.copyProperties(Condominium, CondominiumReturn, "id");
		this.condominiumRepository.save(CondominiumReturn);
		return CondominiumReturn;
	}
	
	public void deleteAll() {
		this.condominiumRepository.deleteAll();
	}
}

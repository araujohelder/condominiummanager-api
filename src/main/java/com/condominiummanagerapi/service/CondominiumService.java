package com.condominiummanagerapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.condominiummanagerapi.model.Condominium;
import com.condominiummanagerapi.repository.CondominiumRepository;
import com.condominiummanagerapi.repository.condominium.filter.Filter;


@Service
public class CondominiumService extends AbstractService<Condominium, CondominiumRepository>{

	@Override
	public List<Condominium> search(Filter filter) {
		return repository.findAll();
	}
}

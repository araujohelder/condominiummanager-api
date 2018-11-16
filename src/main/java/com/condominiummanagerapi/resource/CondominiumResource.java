package com.condominiummanagerapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.condominiummanagerapi.event.ResourceCreatedEvent;
import com.condominiummanagerapi.model.Condominium;
import com.condominiummanagerapi.repository.condominium.filter.CondominiumFilter;
import com.condominiummanagerapi.service.CondominiumService;

@RestController
@RequestMapping("/condominio")
public class CondominiumResource {
	
	@Autowired
	private CondominiumService condominiumService;
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Condominium> findById(@PathVariable Long codigo)  {
		Condominium condominiumReturned = condominiumService.findByid(codigo);
		return condominiumReturned != null ? ResponseEntity.ok(condominiumReturned) : ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Condominium>> findByName(CondominiumFilter planetFilter)  {
		List<Condominium> Condominiums = condominiumService.search(planetFilter);
		return Condominiums != null ? ResponseEntity.ok(Condominiums) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Condominium> save(@Valid @RequestBody Condominium condominium, HttpServletResponse response) {
		Condominium condominiumCreated =  condominiumService.save(condominium);
		publisher.publishEvent(new ResourceCreatedEvent(this, response, condominiumCreated.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(condominiumCreated);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Condominium> remove(@PathVariable Long id){
		condominiumService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Condominium>update(@PathVariable Long id, @Validated @RequestBody Condominium condominium) {
		Condominium condominiumSave = condominiumService.update(id, condominium);
		return ResponseEntity.ok().body(condominiumSave);
	}
}

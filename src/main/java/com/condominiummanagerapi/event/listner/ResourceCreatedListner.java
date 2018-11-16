package com.condominiummanagerapi.event.listner;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.condominiummanagerapi.event.ResourceCreatedEvent;


@Component
public class ResourceCreatedListner implements ApplicationListener<ResourceCreatedEvent>{

	@Override
	public void onApplicationEvent(ResourceCreatedEvent resourceCreated) {
		HttpServletResponse response = resourceCreated.getResponse();
		Long id = resourceCreated.getId();
		addHeaderLocation(response, id);
	}

	private void addHeaderLocation(HttpServletResponse response, Long id) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(id).toUri();
		response.addHeader("Location", uri.toString());
	}
}

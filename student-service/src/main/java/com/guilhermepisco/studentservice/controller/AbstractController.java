package com.guilhermepisco.studentservice.controller;

import java.net.URI;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.guilhermepisco.studentservice.entity.IEntity;

public abstract class AbstractController {
	
	public URI createResourceURI(IEntity obj) {
		return ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
	}

}

package lucasti.viavarejo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import lucasti.viavarejo.services.impl.ApoliceServiceImpl;

@RestController(value = "/apolice")
public class ApoliceController {
	
	@Autowired
	ApoliceServiceImpl service;
	
	

}

package lucasti.viavarejo.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lucasti.viavarejo.models.dtos.ApoliceDTO;
import lucasti.viavarejo.models.entities.Apolice;
import lucasti.viavarejo.services.ApoliceService;

@RestController
@RequestMapping(value = "/apolice")
public class ApoliceController {
	
	@Autowired
	ApoliceService service;
	
	@GetMapping
	public ResponseEntity<List<Apolice>> findAll (){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping(value="/{numero}")
	public ResponseEntity<ApoliceDTO> findByNumero(@PathVariable String numero){
		ApoliceDTO apolice = service.findByNumero(numero);
		return ResponseEntity.ok().body(apolice);
		
	}
	
	@PostMapping
	public ResponseEntity<Apolice> save(@RequestBody @Valid Apolice apolice){
		Apolice apoliceCriada = service.save(apolice);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(apoliceCriada.getNumero())
				.toUri();
		return ResponseEntity.created(uri).body(apoliceCriada);
	}
	
	@PutMapping(value="/{numero}")
	public ResponseEntity<Apolice> update(@RequestBody @Valid Apolice apolice, @PathVariable String numero){
		Apolice apoliceAtualizada = service.update(apolice, numero);
		return ResponseEntity.ok().body(apoliceAtualizada);
	}
	
	@DeleteMapping(value = "/{numero}")
	public ResponseEntity<Apolice> deleteById(@PathVariable String numero) {
		service.deleteByNumero(numero);
		return ResponseEntity.noContent().build();
	}

}

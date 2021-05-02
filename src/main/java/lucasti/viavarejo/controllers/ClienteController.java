package lucasti.viavarejo.controllers;

import java.net.URI;
import java.util.List;

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

import lucasti.viavarejo.models.entities.Cliente;
import lucasti.viavarejo.services.impl.ClienteServiceImpl;

@RestController
@RequestMapping(value="/cliente")
public class ClienteController {
	
	@Autowired
	ClienteServiceImpl service;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> lsCliente = service.findAll();
		return ResponseEntity.ok().body(lsCliente);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable String id){
		Cliente cliente = service.findById(id);
		return ResponseEntity.ok().body(cliente);
		
	}
	
	@PostMapping
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
		Cliente clienteCriado = service.save(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clienteCriado.getId())
				.toUri();
		return ResponseEntity.created(uri).body(clienteCriado);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Cliente> update(@RequestBody Cliente cliente, @PathVariable String id){
		Cliente clienteAtualizado = service.update(cliente, id);
		return ResponseEntity.ok().body(clienteAtualizado);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Cliente> deleteById(@PathVariable String id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}

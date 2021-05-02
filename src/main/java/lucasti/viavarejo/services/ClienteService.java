package lucasti.viavarejo.services;

import java.util.List;

import lucasti.viavarejo.entities.Cliente;


public interface ClienteService {
	
	public List<Cliente> findAll();
	
	public Cliente findById(String id);
	
	public Cliente save(Cliente cliente);
	
	public Cliente update(Cliente cliente, String id);
	
	public void deleteById(String id);

}

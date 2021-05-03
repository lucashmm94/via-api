package lucasti.viavarejo.services;

import java.util.List;

import lucasti.viavarejo.models.entities.Cliente;


public interface ClienteService {
	
	
	/*
	 * Retorna todos clientes
	 * 
	 * @return A lista de todos os clientes.
	 * 
	 */
	public List<Cliente> findAll();
	
	
	/*
	 * Pesquisa Cliente pelo ID.
	 * 
	 * @param id, O id do Cliente que será pesquisado.
	 * 
	 * @return O Cliente que foi pesquisado.
	 * 
	 */
	public Cliente findById(String id);
	
	
	/*
	 * Salva um novo Cliente.
	 * 
	 * @param Cliente, O Cliente que será criado.
	 * 
	 * @return O Cliente que foi salvado.
	 * 
	 */
	public Cliente save(Cliente cliente);
	
	
	/*
	 * Atualiza um Cliente.
	 * 
	 * @param Cliente, O Cliente que será atualizado.
	 * 
	 * @param id, O ID do Cliente que será atualizada.
	 * 
	 * @return O Cliente que foi atualizado.
	 * 
	 */
	public Cliente update(Cliente cliente, String id);
	
	
	/*
	 * Exclui um Cliente pelo ID
	 * 
	 * @param ID, Id do cliente que sera exlcuido.
	 * 
	 */
	public void deleteById(String id);

}

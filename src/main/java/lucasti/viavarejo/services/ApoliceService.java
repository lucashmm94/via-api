package lucasti.viavarejo.services;

import java.util.List;

import lucasti.viavarejo.models.dtos.ApoliceDTO;
import lucasti.viavarejo.models.entities.Apolice;


public interface ApoliceService {
	
	
	/*
	 * Lista todas as Apolices
	 * 
	 * @return A lista de todas as Apolices.
	 * 
	 */
	public List<Apolice> findAll();
	
	/*
	 * Retorna uma nova Apolice.
	 * 
	 * @param numero, .
	 * 
	 * @return A Apolice que foi cadastrada.
	 * 
	 */
	
	public ApoliceDTO findByNumero(String numero);
	
	
	/*
	 * Cadastra uma nova Apolice.
	 * 
	 * @param Apolice, a apolice que vai ser cadastrada.
	 * 
	 * @return A Apolice que foi cadastrada.
	 * 
	 */
	public Apolice save(Apolice apolice);
	
	
	/*
	 * Retorna a apolice.
	 * 
	 * @param Apolice, A Apolice que será atualizada.
	 * 
	 * @param numero, O numero(id) da Apolice que será atualizada.
	 * 
	 * @return A Apolice que foi atualizada.
	 * 
	 */
	public Apolice update(Apolice apolice, String id);
	
	/*
	 * Exclui uma Apolice pelo Numero
	 * 
	 * @param numero, numero(id) da Apolice que será deletada.
	 */
	
	public void deleteByNumero(String numero);

}

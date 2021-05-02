package lucasti.viavarejo.services;

import java.util.List;

import lucasti.viavarejo.models.dtos.ApoliceDTO;
import lucasti.viavarejo.models.entities.Apolice;


public interface ApoliceService {
	
	public List<Apolice> findAll();
	
	public ApoliceDTO findByNumero(String numero);
	
	public Apolice save(Apolice apolice);
	
	public Apolice update(Apolice apolice, String id);
	
	public void deleteByNumero(String numero);

}

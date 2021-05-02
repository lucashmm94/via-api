package lucasti.viavarejo.services;

import java.util.List;

import lucasti.viavarejo.entities.Apolice;


public interface ApoliceService {
	
	public List<Apolice> findAll();
	
	public Apolice findById(String id);
	
	public Apolice save(Apolice apolice);
	
	public Apolice update(Apolice apolice, String id);
	
	public void deleteById(String id);

}

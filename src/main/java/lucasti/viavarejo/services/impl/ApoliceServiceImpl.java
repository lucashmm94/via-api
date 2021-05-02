package lucasti.viavarejo.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lucasti.viavarejo.models.entities.Apolice;
import lucasti.viavarejo.repositories.ApoliceRepository;
import lucasti.viavarejo.services.ApoliceService;


@Service
public class ApoliceServiceImpl implements  ApoliceService {
	
	@Autowired
	ApoliceRepository repository;
	
	private ModelMapper modelmapper = new ModelMapper();
//	private final String MSG_CPF_DUPLICADO = "CPF já está cadastrado!";
//	private final String MSG_NAO_CLIENTE_CADASTRADO = "Cliente não cadastrado";
	
	
	@Override
	public List<Apolice> findAll() {
		return repository.findAll();
	}
	@Override
	public Apolice findByNumero(String numero) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Apolice save(Apolice apolice) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Apolice update(Apolice apolice, String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteByNumero(String id) {
		// TODO Auto-generated method stub
		
	}
	

	

}

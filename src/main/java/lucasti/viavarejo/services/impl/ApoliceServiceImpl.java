package lucasti.viavarejo.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lucasti.viavarejo.exceptions.ResourceNotFoundException;
import lucasti.viavarejo.models.dtos.ApoliceDTO;
import lucasti.viavarejo.models.entities.Apolice;
import lucasti.viavarejo.repositories.ApoliceRepository;
import lucasti.viavarejo.services.ApoliceService;


@Service
public class ApoliceServiceImpl implements  ApoliceService {
	
	@Autowired
	ApoliceRepository repository;
	
	@Autowired
	ClienteServiceImpl clientesService;
	
	private ModelMapper modelMapper = new ModelMapper();

	private final String MSG_APOLICE_NAO_CADASTRADA = "Apólice não cadastrada";
	
	
	@Override
	public List<Apolice> findAll() {
		return repository.findAll();
	}
	@Override
	public ApoliceDTO findByNumero(String numero) {
		ApoliceDTO apoliceDTO = new ApoliceDTO();
		Apolice apoliceBanco = repository.findByNumero(numero)
				.orElseThrow( () ->  new ResourceNotFoundException(MSG_APOLICE_NAO_CADASTRADA));
		modelMapper.map(apoliceBanco, apoliceDTO);
		return apoliceDTO;
	}
	@Override
	public Apolice save(Apolice apolice) {
		if(clientesService.findById(apolice.getCliente().getId()) != null) {
			return repository.save(apolice);
		} 
		return apolice;
	}
	@Override
	public Apolice update(Apolice apolice, String numero) {
		isExitsApolice(numero);
		apolice.setNumero(numero);
		return repository.save(apolice);
	}
	@Override
	public void deleteByNumero(String numero) {
		if(isExitsApolice(numero)) {	
			repository.deleteById(numero);
		}	
	}
	
	private Boolean isExitsApolice(String numero) {
		return repository.existsByNumero(numero).orElseThrow(() -> new ResourceNotFoundException(MSG_APOLICE_NAO_CADASTRADA));
	}

}

package lucasti.viavarejo.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lucasti.viavarejo.entities.Cliente;
import lucasti.viavarejo.exceptions.BusinessException;
import lucasti.viavarejo.exceptions.ResourceNotFoundException;
import lucasti.viavarejo.repositories.ClienteRepository;
import lucasti.viavarejo.services.ClienteService;


@Service
public class ClienteServiceImpl implements  ClienteService {
	
	@Autowired
	ClienteRepository repository;
	
	private ModelMapper modelmapper = new ModelMapper();
	private final String MSG_CPF_DUPLICADO = "CPF já está cadastrado!";
	private final String MSG_NAO_CLIENTE_CADASTRADO = "Cliente não cadastrado";
	

	@Override
	public List<Cliente> findAll() {
		return repository.findAll();
	}

	@Override
	public Cliente findById(String id) {
		return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(MSG_NAO_CLIENTE_CADASTRADO));
	}

	@Override
	public Cliente save(Cliente cliente) {
		if(repository.existsByCpf(cliente.getCpf())) {
			throw new BusinessException(MSG_CPF_DUPLICADO);
		}
		return repository.save(cliente);
	}

	@Override
	public Cliente update(Cliente cliente, String id) {
		if (repository.existsByCpfAndIdNot(cliente.getCpf(), id)) {
			throw new BusinessException( MSG_CPF_DUPLICADO);
		}
		Cliente clienteBanco = findById(id);
		modelmapper.map(cliente, clienteBanco);
		clienteBanco.setId(id);
		return repository.save(clienteBanco);
	}

	@Override
	public void deleteById(String id) {
		findById(id);
		repository.deleteById(id); 
		
	}

}

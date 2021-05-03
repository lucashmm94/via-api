package lucasti.viavarejo.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lucasti.viavarejo.exceptions.BusinessException;
import lucasti.viavarejo.exceptions.ResourceNotFoundException;
import lucasti.viavarejo.models.entities.Cliente;
import lucasti.viavarejo.repositories.ClienteRepository;
import lucasti.viavarejo.services.ClienteService;


@Service
public class ClienteServiceImpl implements  ClienteService {
	
	@Autowired
	ClienteRepository repository;
	
	private ModelMapper modelmapper = new ModelMapper();
	private final String MSG_CPF_DUPLICADO = "CPF já está cadastrado!";
	private final String MSG_NAO_CLIENTE_CADASTRADO = "Cliente não cadastrado";
	private final String MSG_CLIENTE_CADASTRADO_DUPLICADO = "Cliente já cadastrado";
	

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
		if (repository.existsById(cliente.getId())) {
			new BusinessException(MSG_CLIENTE_CADASTRADO_DUPLICADO);
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
		isExitsCliente(id);
		repository.deleteById(id); 
		
	}

	private Boolean isExitsCliente(String cpf) {
		return repository.existsByCpf(cpf).orElseThrow(() -> new ResourceNotFoundException(MSG_NAO_CLIENTE_CADASTRADO));
	}
}

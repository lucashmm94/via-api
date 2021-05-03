package lucasti.viavarejo.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import br.com.caelum.stella.validation.CPFValidator;
import lucasti.viavarejo.exceptions.BusinessException;
import lucasti.viavarejo.exceptions.ResourceNotFoundException;
import lucasti.viavarejo.models.entities.Cliente;
import lucasti.viavarejo.repositories.ClienteRepository;
import lucasti.viavarejo.services.ClienteService;


@Service
public class ClienteServiceImpl implements  ClienteService {
	
	@Autowired
	ClienteRepository repository;
	
	CPFValidator cpfValidator = new CPFValidator(); 
	
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
		isDuplicadoCPF(cliente.getCpf(),null);
		return repository.save(cliente);
	}

	@Override
	public Cliente update(Cliente cliente, String id) {
		isDuplicadoCPF(cliente.getCpf(),id);
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
	
	
	private void isDuplicadoCPF(String cpf, String id) {
		isCPFValido(cpf);
		if (!ObjectUtils.isEmpty(id)) {
			if (repository.existsByCpfAndIdNot(cpf, id)) {
				throw new BusinessException( MSG_CPF_DUPLICADO);
			}
		} else {
			if(repository.existsByCpf(cpf).get()) {
				throw new BusinessException( MSG_CPF_DUPLICADO);
			}
		}
	}
	
	private void isCPFValido(String cpf){
		if(!cpfValidator.isEligible(cpf)) {
			throw new BusinessException("CPF inválido");
		}
	}
	
}

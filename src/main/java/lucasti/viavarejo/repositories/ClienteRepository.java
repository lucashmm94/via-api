package lucasti.viavarejo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import lucasti.viavarejo.entities.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

	Boolean existsByCpf(String cpf);
	
	Boolean existsByCpfAndIdNot(String cpf, String id);
}

package lucasti.viavarejo.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import lucasti.viavarejo.models.entities.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

	
	Boolean existsByCpfAndIdNot(String cpf, String id);
	boolean existsById (String id);
	
	Optional<Boolean> existsByCpf(String cpf);
	
}

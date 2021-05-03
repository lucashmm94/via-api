package lucasti.viavarejo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import lucasti.viavarejo.models.entities.Cliente;
import java.util.Optional;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

	
	Boolean existsByCpfAndIdNot(String cpf, String id);
	
	Optional<Boolean> existsByCpf(String cpf);
	
}

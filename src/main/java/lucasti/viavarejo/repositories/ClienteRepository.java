package lucasti.viavarejo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import lucasti.viavarejo.entities.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

	
}

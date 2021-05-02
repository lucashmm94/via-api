package lucasti.viavarejo.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import lucasti.viavarejo.models.entities.Apolice;

public interface ApoliceRepository extends MongoRepository<Apolice,String> {
	
	Optional<Apolice> findByNumero(String numero);
	
	Optional<Boolean> existsByNumero(String numero);

}

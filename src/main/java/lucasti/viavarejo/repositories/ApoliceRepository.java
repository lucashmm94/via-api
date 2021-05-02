package lucasti.viavarejo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import lucasti.viavarejo.models.entities.Apolice;

public interface ApoliceRepository extends MongoRepository<Apolice,String> {

}

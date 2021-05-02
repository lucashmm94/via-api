package lucasti.viavarejo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import lucasti.viavarejo.entities.Apolice;

public interface ApoliceRepository extends MongoRepository<Apolice,String> {

}

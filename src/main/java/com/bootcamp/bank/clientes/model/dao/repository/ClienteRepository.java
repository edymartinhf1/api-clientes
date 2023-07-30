package com.bootcamp.bank.clientes.model.dao.repository;

import com.bootcamp.bank.clientes.model.dao.ClienteDao;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ClienteRepository extends ReactiveMongoRepository<ClienteDao,String> {
    @Query("{'numeroCelular':?0}")
    Mono<ClienteDao> findByNumeroCelular(String numeroCelular);
}

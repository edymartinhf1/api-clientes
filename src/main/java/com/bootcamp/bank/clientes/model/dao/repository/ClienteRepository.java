package com.bootcamp.bank.clientes.model.dao.repository;

import com.bootcamp.bank.clientes.model.dao.ClienteDao;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends ReactiveMongoRepository<ClienteDao,String> {

}

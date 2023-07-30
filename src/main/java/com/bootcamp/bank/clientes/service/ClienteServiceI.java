package com.bootcamp.bank.clientes.service;

import com.bootcamp.bank.clientes.model.dao.ClienteDao;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClienteServiceI {
    Flux<ClienteDao> findAll();
    Mono<ClienteDao> findById(String id);
    Mono<ClienteDao> findByNumeroCelular(String numeroCelular);
    Mono<ClienteDao> save(ClienteDao clienteDao);
    Mono<ClienteDao> update(ClienteDao clienteDao,String id);
    void deleteById(String id);
}

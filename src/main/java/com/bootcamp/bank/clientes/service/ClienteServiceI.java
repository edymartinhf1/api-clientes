package com.bootcamp.bank.clientes.service;

import com.bootcamp.bank.clientes.model.dao.ClienteDao;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClienteServiceI {
    Flux<ClienteDao> findAll();
    Mono<ClienteDao> findById(String id);

    Mono<ClienteDao> save(ClienteDao clienteDao);

    void deleteById(String id);
}

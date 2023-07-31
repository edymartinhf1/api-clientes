package com.bootcamp.bank.clientes.service.impl;

import com.bootcamp.bank.clientes.exception.BusinessException;
import com.bootcamp.bank.clientes.model.dao.ClienteDao;
import com.bootcamp.bank.clientes.model.dao.repository.ClienteRepository;
import com.bootcamp.bank.clientes.service.ClienteServiceI;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase Servicio clientes
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteServiceI {

    private final ClienteRepository clienteRepository;

    @Override
    public Flux<ClienteDao> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Mono<ClienteDao> findById(String id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Mono<ClienteDao> findByNumeroCelular(String numeroCelular) {
        return clienteRepository.findByNumeroCelular(numeroCelular).filter(cliente->cliente.getTipoCli().equals("PER")).next();
    }

    @Override
    public Mono<ClienteDao> save(ClienteDao clienteDao) {
        return clienteRepository.save(clienteDao);
    }

    @Override
    public Mono<ClienteDao> update(ClienteDao clienteDao,String id) {
        return findById(id)
                .switchIfEmpty(Mono.error(()->new BusinessException("No existe cliente con el id "+id)))
                .flatMap(c->save(clienteDao));
    }

    @Override
    public void deleteById(String id) {
        clienteRepository.deleteById(id);
    }
}

package com.bootcamp.bank.clientes.controller;

import com.bootcamp.bank.clientes.model.Cliente;
import com.bootcamp.bank.clientes.model.ClientePost;
import com.bootcamp.bank.clientes.model.dao.ClienteDao;
import com.bootcamp.bank.clientes.service.ClienteServiceI;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase Cliente Permite el manejo de la informacion de clientes
 */
@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
@Log4j2
public class ClientesController {

    private final ClienteServiceI clienteServiceI;

    /**
     * Permite obtener todos los clientes
     * @return
     */
    @GetMapping
    public Flux<Cliente> getAll() {
        return clienteServiceI.findAll()
                .map(this::fromClienteDaoToClienteDto);
    }



    /**
     * Permite Obtener clientes por id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Mono<Cliente> findClienteById(@PathVariable String id) {
        return clienteServiceI.findById(id)
                .map(this::fromClienteDaoToClienteDto);
    }

    @GetMapping("/celular/{numeroCelular}")
    public Mono<Cliente> findClienteByNumeroCelular(@PathVariable String numeroCelular) {
        return clienteServiceI.findByNumeroCelular(numeroCelular)
                .map(this::fromClienteDaoToClienteDto);
    }


    /**
     * Permite Registrar clientes
     * @param cliente
     * @return
     */
    @PostMapping
    public Mono<Cliente> createCliente(@RequestBody ClientePost cliente) {
        log.info("cliente "+cliente.toString());
        return clienteServiceI.save(this.fromClientePostToClienteDao(cliente))
                .map(this::fromClienteDaoToClienteDto);
    }

    /**
     * Permite Actualizar clientes
     * @param cliente
     * @return
     */
    @PutMapping("/{id}")
    public Mono<Cliente> modifyCliente(@RequestBody ClientePost cliente,@PathVariable String id) {
        return clienteServiceI.update(fromClientePostToClienteDao(cliente),id)
                .map(this::fromClienteDaoToClienteDto);
    }

    /**
     * Permite eliminar clientes
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable String id) {
        clienteServiceI.deleteById(id);
    }

    private Cliente fromClienteDaoToClienteDto(ClienteDao clienteDao) {
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteDao,cliente);
        return cliente;
    }

    private ClienteDao fromClientePostToClienteDao(ClientePost clientePost) {
        ClienteDao cliente = new ClienteDao();
        BeanUtils.copyProperties(clientePost,cliente);
        return cliente;
    }
}

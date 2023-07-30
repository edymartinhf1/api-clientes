package com.bootcamp.bank;

import com.bootcamp.bank.clientes.model.dao.ClienteDao;
import com.bootcamp.bank.clientes.service.ClienteServiceI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import java.util.List;

import static com.mongodb.assertions.Assertions.assertNotNull;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;



@SpringBootTest
class ApiClientesApplicationTests {
	@Autowired
	private ClienteServiceI clienteServiceI;
	@Test
	void contextLoads() {
		assertThat(clienteServiceI).isNotNull();
	}

	@Test
	void getClientes(){
		List<ClienteDao> clientes = clienteServiceI.findAll().collectList().block();
		assertThat(clientes.size()>0);

	}
	@Test
	void saveCliente(){
		ClienteDao client=new ClienteDao();
		client.setNombre("EDUARDO SANCHEZ GUZMAN");
		client.setTipoCli("EMP");
		client.setLimiteCredito(30000.00);
		client.setNroDocumento("98765423");
		client.setTipoDocumento("DNI");
		Mono<ClienteDao> cliente= clienteServiceI.save(client);
		ClienteDao clienteDao= cliente.block();
		assertNotNull(clienteDao);

	}

	@Test
	void updateCliente(){

		ClienteDao clientNuevo=new ClienteDao();
		clientNuevo.setNombre("MARIELA SANTOS GUZMAN TEST");
		clientNuevo.setTipoCli("EMP");
		clientNuevo.setLimiteCredito(20000.00);
		clientNuevo.setNroDocumento("98765424");
		clientNuevo.setTipoDocumento("DNI");
		Mono<ClienteDao> cliente= clienteServiceI.save(clientNuevo);
		ClienteDao clienteDao= cliente.block();

		String id = clienteDao.getId();
		ClienteDao clientUpdate=new ClienteDao();
		clientUpdate.setId(id);
		clientUpdate.setNombre("MARIELA SANTOS GUZMAN TEST 2");
		clientUpdate.setTipoCli("EMP");
		clientUpdate.setLimiteCredito(30000.00);
		clientUpdate.setNroDocumento("98765423");
		clientUpdate.setTipoDocumento("DNI");
		Mono<ClienteDao> clienteup= clienteServiceI.update(clientUpdate,id);
		assertNotNull(clienteup);


	}

	@Test
	void findByIdCliente(){

		ClienteDao clientNuevo=new ClienteDao();
		clientNuevo.setNombre("CARLOS GUZMAN TEST");
		clientNuevo.setTipoCli("PER");
		clientNuevo.setLimiteCredito(20000.00);
		clientNuevo.setNroDocumento("88765424");
		clientNuevo.setTipoDocumento("DNI");
		Mono<ClienteDao> cliente= clienteServiceI.save(clientNuevo);
		ClienteDao clienteDao= cliente.block();

		Mono<ClienteDao> clienteFind= clienteServiceI.findById(clienteDao.getId());
		ClienteDao clienteF= clienteFind.block();
		assertNotNull(clienteF);

	}

}

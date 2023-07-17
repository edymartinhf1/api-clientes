package com.bootcamp.bank;

import com.bootcamp.bank.clientes.service.ClienteServiceI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ApiClientesApplicationTests {
	@Autowired
	private ClienteServiceI clienteServiceI;
	@Test
	void contextLoads() {
		assertThat(clienteServiceI).isNotNull();
	}

}

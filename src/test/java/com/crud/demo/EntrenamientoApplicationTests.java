package com.crud.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.crud.demo.interfaceService.I_clienteService;
import com.crud.demo.modelo.Clientes;

@SpringBootTest
class EntrenamientoApplicationTests {

	@Autowired
	private I_clienteService iclients;
	
	@Test
	void contextLoads() {
		
		Clientes cliente = new Clientes();
		
		cliente.setId(77);
		cliente.setTelefono("12324");
		cliente.setApellido("sdfsd");
		cliente.setNombre("hola");
		cliente.setCorreo("bogo");
		cliente.setCiudad("hola");
		
		iclients.save(cliente);
		
	}
	
	@Test
	void listar() {
		
		for (Clientes client : iclients.listar()) {
			System.out.print(client.getId() + "	");
			System.out.print(client.getNombre() + "	");
			System.out.print(client.getCiudad());
			System.out.println("");
		}
		
	}

}

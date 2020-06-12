package com.crud.demo.interfaceService;

import java.util.List;
import java.util.Optional;
import com.crud.demo.modelo.Clientes;


public interface I_clienteService {

	public List<Clientes>listar();
	public Optional<Clientes>listar(int id);
	public int save(Clientes c);
	public void delete(int id);	
	
}

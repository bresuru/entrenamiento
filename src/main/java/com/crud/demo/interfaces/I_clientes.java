package com.crud.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud.demo.modelo.Clientes;

@Repository
public interface I_clientes extends CrudRepository<Clientes, Integer> {

}

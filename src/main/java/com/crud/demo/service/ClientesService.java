package com.crud.demo.service;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.jsf.FacesContextUtils;

import com.crud.demo.interfaceService.I_clienteService;
import com.crud.demo.interfaces.I_clientes;
import com.crud.demo.modelo.Clientes;
//
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperExportManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ClientesService implements I_clienteService {

	@Autowired
	private I_clientes data;
	
	@Override
	public List<Clientes> listar() {
		// TODO Auto-generated method stub
		return (List<Clientes>)data.findAll();
	}

	@Override
	public Optional<Clientes> listar(int id) {
		
		return data.findById(id);
	}

	@Override
	public int save(Clientes c) {
		int res=0;
		Clientes clientes=data.save(c);
		if(!clientes.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}	

}

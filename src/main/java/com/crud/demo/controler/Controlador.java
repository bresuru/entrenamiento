package com.crud.demo.controler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.expression.spel.support.ReflectivePropertyAccessor.OptimalPropertyAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;

import com.crud.demo.interfaceService.I_clienteService;
import com.crud.demo.modelo.Clientes;
import com.crud.demo.service.ReporteService;

@Controller
@RequestMapping
public class Controlador {
	
	private static Logger logger = LoggerFactory.getLogger(Controlador.class);
	
	@Autowired
	private I_clienteService i_clienteService;
	
	@Autowired
	private ReporteService jasperReportsViewResolver;
	
	@GetMapping("/index")	
	public String listar(@RequestParam(name="name", required = false, defaultValue =  "Hola") String name, Model model) {
	//ya salio
		List<Clientes>listClient=i_clienteService.listar();		
	    model.addAttribute("listClientes", listClient);	    
	    model.addAttribute("name", name);
	    model.addAttribute("clientes", new Clientes());
		return "index";	
		
	}	
	
	@GetMapping("/Json")
	private String json () {
		return "json";
	}
	
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("clientes", new Clientes());
		return "redirect:/index";
	}
	
	@PostMapping("/save")
	public String save(@Valid Clientes c, Model model) {
		i_clienteService.save(c);
		return "redirect:/index";
	}
	
	@PostMapping("/update/{id}")
	private String update(@Valid Clientes client, 
			@PathVariable int id, Model model) {
		
		String men = null;
		
		client.setId(id);
		i_clienteService.save(client);
		
		return "redirect:/index?name=Registro creado";
	}
	
	//Find client
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Clientes>clientes=i_clienteService.listar(id);
		model.addAttribute("clientes", clientes);
		model.addAttribute("id_c", clientes.get().getId());
		return "form";
		
	}
	
	//Find client for ajax
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		Optional<Clientes>clientes=i_clienteService.listar(id);
		model.addAttribute("clientes", clientes);
		return "index?name=Editado ";
	}
	
	@GetMapping("/eliminar/{id}")
	public String delete(Model model, @PathVariable int id ) {
		i_clienteService.delete(id);
		return "redirect:/index";
	}	
	
	@GetMapping("/app")
	public String index() {
		return "index";
	}
	
	@GetMapping("/json")
	public String getjson() {
		return "json";
	}	
	
	
	@GetMapping("/report")
    public String reporte(Model model) {
		
		jasperReportsViewResolver.reporte();
		
		return "redirect:/index";
		
	}
	
	public List<Clientes> dataSource() {
		List<Clientes> clientes = new ArrayList<Clientes>(); 
		Clientes cliente = new Clientes();
		cliente.setNombre("Sergio");
		cliente.setApellido("Viancha");
		cliente.setCiudad("Medellin");
		cliente.setTelefono("3102856639");
		cliente.setCorreo("duranlex66@gmail.com");
		
		clientes.add(cliente);
		
		return clientes;
	}
}

package com.crud.demo.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.context.annotation.RequestScope;

import com.crud.demo.interfaces.I_clientes;
import com.crud.demo.modelo.Clientes;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReporteService {

	@Autowired
	private I_clientes client;

	public void reporte() {

		// TODO Auto-generated method stub
		List<Clientes> listClient = (List<Clientes>) client.findAll();

		String win_user = System.getProperty("user.name");

		String path = "C:\\Users\\" + win_user + "\\Downloads\\";

		try {
			// compilo el reporte
			File f = ResourceUtils.getFile("classpath:reporte1.jrxml");
			JasperReport jasper = JasperCompileManager.compileReport(f.getAbsolutePath());

			// guardo la lista
			JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(listClient);

			// Parametros
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("supervisor", "Breiner");

			// cargart el reporte
			JasperPrint jprint = JasperFillManager.fillReport(jasper, map, datasource);

			// imprimir el reporte
			JasperExportManager.exportReportToPdfFile(jprint, path + "report_mobile.pdf");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error -> " + e.getMessage());
		}

	}

}

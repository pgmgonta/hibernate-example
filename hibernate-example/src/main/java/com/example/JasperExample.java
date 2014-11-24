package com.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.data.DataAdapter;
import net.sf.jasperreports.data.DefaultDataAdapterServiceFactory;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class JasperExample {
	
	public static void main(String... args) {
		JasperExample example = new JasperExample();
		example.exportReport();
	}
	
	public void exportReport() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("userName", "som");
		
		try (InputStream template = getClass().getResourceAsStream("report/example.jrxml")) {
			JasperReport report = JasperCompileManager.compileReport(template);
			JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
			JasperExportManager.exportReportToPdfFile(jasperPrint, "example.pdf");
			JasperExportManager.exportReportToHtmlFile(jasperPrint, "example.html");
		} catch(IOException | JRException e) {
			e.printStackTrace();
		}
		
	}

}

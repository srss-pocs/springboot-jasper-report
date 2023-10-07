package com.example.jasperreport.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.jasperreport.entity.Product;

import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
@Slf4j
public class InvoiceService {

	public byte[] downloadInvoice() {
		byte[] data = null;
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
				Arrays.asList(new Product(121, "Keyboard", 54884), new Product(122, "Mouse", 54884),
						new Product(123, "Laptop", 54884), new Product(124, "Mobile", 54884),
						new Product(125, "Headphone", 54884)),
				false);

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("total", "7000");

		JasperReport compileReport;
		try {
			compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/invoice.jrxml"));
			JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, parameters, beanCollectionDataSource);
			data = JasperExportManager.exportReportToPdf(jasperPrint);
		} catch (FileNotFoundException | JRException ex) {
			log.error("Error occurred -->>", ex);
		}
		return data;
	}
}

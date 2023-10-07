package com.example.jasperreport.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.jasperreport.service.InvoiceService;

import net.sf.jasperreports.engine.JRException;

@Controller
public class InvoiceController {
	
	@Autowired
	InvoiceService invoiceService;

	@GetMapping(value = "/downloadPdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<byte[]> downloadInvoice() throws JRException, IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(invoiceService.downloadInvoice());
	}

}

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.cliente.CnpjCliente;
import com.example.demo.cliente.ViaCepClient;
import com.example.demo.dto.CnpjDto;

@RestController
@RequestMapping("/api/v1/endpoint")
public class EndPoint {
	
	ViaCepClient viaCepClient;
	RestTemplate restTemplate;
	CnpjCliente cnpjCliente;
	
	@Autowired
	public EndPoint(@Qualifier("restTemplate") RestTemplate restTemplate, ViaCepClient viaCepClient, CnpjCliente cnpjCliente){
		this.viaCepClient = viaCepClient;
		this.restTemplate = restTemplate;
		this.cnpjCliente = cnpjCliente;
	}
	
	/*
	 * @GetMapping("/feign/{cep}") public ResponseEntity
	 * testFeign(@PathVariable(value = "cep") String cep) { return
	 * ResponseEntity.ok(this.viaCepClient.getViaCep(cep)); }
	 * 
	 * @GetMapping("/resttemplate/{cep}") public ResponseEntity
	 * restTemplate(@PathVariable(value = "cep") String cep) { String url =
	 * String.format("https://viacep.com.br/ws/%s/json/", cep); return
	 * ResponseEntity.ok(this.restTemplate.exchange(url, HttpMethod.GET, null,
	 * ViaCepDto.class).getBody()); }
	 */
	
	@GetMapping("/feign/{cnpj}")
	public ResponseEntity testFeign(@PathVariable(value = "cnpj") String cnpj) {
		return ResponseEntity.ok(this.cnpjCliente.getCnpj(cnpj));
	}
	
	@GetMapping("/resttemplate/{cnpj}")
	public ResponseEntity restTemplate(@PathVariable(value = "cnpj") String cnpj) {
		String url = String.format("https://www.receitaws.com.br/v1/cnpj/", cnpj);
		return ResponseEntity.ok(this.restTemplate.exchange(url, HttpMethod.GET, null, CnpjDto.class).getBody());
	}
}

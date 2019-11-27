package com.example.demo.cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.CnpjDto;

@Service
@FeignClient(url="https://www.receitaws.com.br/v1", name="receitaws.com.br")
public interface CnpjCliente {
	
	@GetMapping("/cnpj/{cnpj}")
	CnpjDto getCnpj(@PathVariable(value = "cnpj") String cnpj);
	
}

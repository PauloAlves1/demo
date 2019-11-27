package com.example.demo.cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.ViaCepDto;

@Service
@FeignClient(url="http://viacep.com.br/ws", name="viacep.com.br")
public interface ViaCepClient {
	
	@GetMapping("/{cep}/json/")
	ViaCepDto getViaCep(@PathVariable(value = "cep") String cep);
	
}

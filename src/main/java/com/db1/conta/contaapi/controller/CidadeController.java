package com.db1.conta.contaapi.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.db1.conta.contaapi.domain.dto.CidadeResponseDTO;
import com.db1.conta.contaapi.service.CidadeService;

@RestController
@RequestMapping("/api/cidades")
public class CidadeController {
	
	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping("/todas-cidades")
	public List<CidadeResponseDTO> todasCidades(){
		return cidadeService.buscarTodasAsCidades();
	}
	
	@GetMapping
	public CidadeResponseDTO cidadePorNome(@RequestParam("nome") String nome) { //RequestParam
		return cidadeService.buscarPorNome(nome);		
	}
	
	@GetMapping("/{id}")
	public CidadeResponseDTO cidadePorId(@PathVariable("id") Long id) {
		return cidadeService.buscarPorId(id);
	}
}

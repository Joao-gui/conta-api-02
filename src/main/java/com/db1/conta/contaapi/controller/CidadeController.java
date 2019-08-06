package com.db1.conta.contaapi.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.db1.conta.contaapi.domain.dto.CidadePersistDTO;
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
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED) //Adicionar o status 201
	public CidadeResponseDTO salvar(@RequestBody CidadePersistDTO body) {
		return cidadeService.save(body);
	}
	
	@PutMapping("/{id}")
	public CidadeResponseDTO atualizar (@PathVariable("id") Long id, @RequestBody CidadePersistDTO body) {
		return cidadeService.update(id, body);
	}
	
	@DeleteMapping("/{id}")
	public void deletar (@PathVariable("id") Long id) {
		cidadeService.delete(id);
	}
}

package com.db1.conta.contaapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1.conta.contaapi.adapter.CidadeAdapter;
import com.db1.conta.contaapi.domain.dto.CidadePersistDTO;
import com.db1.conta.contaapi.domain.dto.CidadeResponseDTO;
import com.db1.conta.contaapi.domain.entity.Cidade;
import com.db1.conta.contaapi.repository.CidadeReposiroty;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeReposiroty cidadeReposiroty;
	
	public CidadeResponseDTO save(CidadePersistDTO dto) {
		Cidade cidade = new Cidade(dto.getNome(), dto.getEstado());
		cidadeReposiroty.save(cidade);
		return CidadeAdapter.entityToResponse(cidade);
	}
	
	public CidadeResponseDTO update(Long cidadeId, CidadePersistDTO dto) {
		Cidade cidade = cidadeReposiroty.findById(cidadeId)
		.orElseThrow(() -> new RuntimeException("Cidade de ID " + cidadeId + " não encontrada."));
		cidade.alterar(dto.getNome(), dto.getEstado());
		cidadeReposiroty.save(cidade);
		return CidadeAdapter.entityToResponse(cidade);
		
	}
	
	public void delete(Long cidadeId) {
		Optional<Cidade> opCidade = cidadeReposiroty.findById(cidadeId);
		if (opCidade.isPresent()) {
			Cidade cidade = opCidade.get();
			cidadeReposiroty.delete(cidade);
		}else {
			throw new RuntimeException("Cidade de id " + cidadeId + " não encontrado.");
		}
		
	}
	
	public List<CidadeResponseDTO> buscarTodasAsCidades() {
		return CidadeAdapter.entityToResponse(cidadeReposiroty.findAll());		
	}
	
	public CidadeResponseDTO buscarPorId(Long cidadeId) {
		Optional<Cidade> opCidade = cidadeReposiroty.findById(cidadeId);
		if (opCidade.isPresent()) {
			Cidade cidade = opCidade.get();
			return CidadeAdapter.entityToResponse(cidade);
		}
		throw new RuntimeException("Cidade de ID " + cidadeId + " não encontrada");
	}
	
	public CidadeResponseDTO buscarPorNome(String nome) {
		Optional<Cidade> opCidade = cidadeReposiroty.findByNomeOptional(nome);
		if(opCidade.isPresent()) {
			Cidade cidade = opCidade.get();
			CidadeResponseDTO cidadeResponse = CidadeAdapter.entityToResponse(cidade);
			return cidadeResponse;
		}
		throw new RuntimeException("Cidade de nome " + nome + " não encontrado.");
		
		//java 8
		//return cidadedRepository.findbyNomeOptional(nome).map(CidadeAdapter: :entetyToResponse)
		//.orElseTrhow(() ->
			//new RunTimeException("Cidade de nome " + nome + " não entrado.");
	}
}

package com.db1.conta.contaapi.domain.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

public class Cliente {
	
	private Long id;
	
	private String nome;
	
	private List<Endereco> endereco = new ArrayList<Endereco>();
	
	private List<Conta> conta = new ArrayList<Conta>();
		
	private String cpf;
	
	public Cliente (String nome, String cpf) {
		Assert.hasText(nome, "Nome é obrigatório.");
		Assert.hasText(cpf, "CPF é obrigatório.");
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public List<Conta> getConta() {
		return conta;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public String getCpf() {
		return cpf;
	}

}

package com.db1.conta.contaapi.domain.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

public class Conta {
	
	private Long id;
	
	private Agencia agencia;
	
	private ContaTIpo contaTipo;
	
	private String numero;
	
	private Cliente cliente;
	
	private Double saldo;
	
	private List<Historico> historico = new ArrayList<Historico>();
	
	public Conta (Agencia agencia, ContaTIpo contaTipo, String numero, Cliente cliente, Double saldo) {
		Assert.notNull(agencia, "Agencia é obrigatória.");
		Assert.notNull(contaTipo, "Conta Tipo é obrigatório.");
		Assert.hasText(numero, "Numero é obrigatório.");
		Assert.notNull(cliente, "Cliente é obrigatório.");
		Assert.notNull(saldo, "Saldo é obrigatório.");
		this.agencia = agencia;
		this.contaTipo = contaTipo;
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = saldo;		
	}

	public Long getId() {
		return id;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public List<Historico> getHistorico() {
		return historico;
	}

	public ContaTIpo getContaTipo() {
		return contaTipo;
	}

	public String getNumero() {
		return numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Double getSaldo() {
		return saldo;
	}

}

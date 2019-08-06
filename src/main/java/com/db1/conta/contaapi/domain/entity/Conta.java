package com.db1.conta.contaapi.domain.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.util.Assert;

@Entity
@Table(name = "conta")

public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "agencia_id", nullable = false)
	private Agencia agencia;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "contaTipo", length = 40, nullable = false)
	private ContaTIpo contaTipo;
	
	@Column(name = "numero", length = 20, nullable = false, unique = true)
	private String numero;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
	
	@Column(name = "saldo", precision = 14, scale = 2, nullable = false)
	private Double saldo;
	
	@ElementCollection
	@CollectionTable(name = "historico", joinColumns = @JoinColumn(name = "conta_id"))
	private List<Historico> historico = new ArrayList<Historico>();
	
	protected Conta() {}
	
	public Conta (Agencia agencia, ContaTIpo contaTipo, String numero, Cliente cliente) {
		Assert.notNull(agencia, "Agencia é obrigatória.");
		Assert.notNull(contaTipo, "Conta Tipo é obrigatório.");
		Assert.hasText(numero, "Numero é obrigatório.");
		Assert.notNull(cliente, "Cliente é obrigatório.");
		this.agencia = agencia;
		this.contaTipo = contaTipo;
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = 0.0;		
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
	
	public void depositar(double valor) {		
		this.saldo += valor;
		this.historico.add(new Historico(HistoricoTipo.ENTRADA, LocalDateTime.now(), valor, saldo));
	}	

}

package com.db1.conta.contaapi.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.util.Assert;

@Embeddable

public class Historico {
	
	//private Long id;
	
	@Enumerated(EnumType.STRING)
	private HistoricoTipo historicoTipo;
	
	@Column(name = "data", length = 50, nullable = false)
	private LocalDateTime data;
	
	@Column(name = "valor", precision = 14, scale = 2, nullable = false)
	private Double valor;
	
	//private Conta conta;
	
	@Column(name = "valorResultante", precision = 14, scale = 2, nullable = false)
	private Double valorResultante;
	
	public Historico (HistoricoTipo historicoTipo,LocalDateTime data, Double valor, Double valorResultante) {
		Assert.notNull(historicoTipo, "Hitórico Tipo é obrigatório.");
		Assert.notNull(data, "Data é obrigatória.");
		Assert.notNull(valor, "Valor é obrigatório.");
		//Assert.notNull(conta, "Conta é obrigatória.");
		Assert.notNull(valorResultante, "Valor Resultante é obrigatório.");
		this.historicoTipo = historicoTipo;
		this.data = data;
		this.valor = valor;
		//this.conta = conta;
		this.valorResultante = valorResultante;		
	}

//	public Long getId() {
//		return id;
//	}

	public HistoricoTipo getHistoricoTipo() {
		return historicoTipo;
	}

	public LocalDateTime getData() {
		return data;
	}

	public Double getValor() {
		return valor;
	}

//	public Conta getConta() {
//		return conta;
//	}

	public Double getValorResultante() {
		return valorResultante;
	}

}

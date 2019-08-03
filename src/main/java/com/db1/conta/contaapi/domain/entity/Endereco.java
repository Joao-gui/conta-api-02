package com.db1.conta.contaapi.domain.entity;



import javax.persistence.Column;
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
@Table(name = "endereco")

public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	

	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;

	@Column(name = "logradouro", length = 60, nullable = false)
	private String logradouro;

	@Column(name = "numero", length = 20, nullable = false)
	private String numero;	
	
	//@Column(name = "cep", length = 9, nullable = false)
	//private String cep;

	@ManyToOne
	@JoinColumn(name = "cidade_id", nullable = false)
	private Cidade cidade;

	//public String getCep() {
	//	return cep;
	//}

	//public void setCep(String cep) {
	//	this.cep = cep;
	//}

	@Enumerated(EnumType.STRING)
	@Column(name = "tipoEndereco", length = 12, nullable = false)
	private TipoEndereco tipoEndereco;

	@Column(name = "complemento", length = 60)
	private String complemento;
	
	protected Endereco() {}
	
	public Endereco (Cliente cliente, String logradouro, String numero, Cidade cidade, TipoEndereco tipoEndereco, String complemento) {
		Assert.hasText(logradouro, "Nome do logradouro obrigatório.");
		Assert.hasText(numero, "Número obrigatório.");
		Assert.notNull(cliente, "Cliente obrigatório.");
		Assert.notNull(cidade, "Cidade obrigatória.");
		Assert.notNull(tipoEndereco, "Tipo endereço obrigatório.");		
		
		this.cliente = cliente;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.tipoEndereco = tipoEndereco;
		this.complemento = complemento;			
	}

	public Long getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}

	public String getComplemento() {
		return complemento;
	}
	
	
	
	

}

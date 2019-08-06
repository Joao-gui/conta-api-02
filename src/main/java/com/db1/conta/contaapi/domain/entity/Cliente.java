package com.db1.conta.contaapi.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.util.Assert;

@Entity
@Table(name = "cliente")
				

public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", length = 80, nullable = false)
	private String nome;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Endereco> endereco = new ArrayList<Endereco>();

//	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
//	@JoinColumn(name = "conta_id", nullable = false)
//	private List<Conta> conta = new ArrayList<Conta>();

	@Column(name = "cpf", length = 20, nullable = false, unique = true)
	private String cpf;
	
	protected Cliente() {}
	
	public Cliente (String nome, String cpf) {
		Assert.hasText(nome, "Nome é obrigatório.");
		Assert.hasText(cpf, "CPF é obrigatório.");
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public void addEndereco(String logradouro, String numero, Cidade cidade, TipoEndereco tipoEndereco, String complemento) {
		Endereco endereco = new Endereco(this, logradouro, numero, cidade, tipoEndereco, complemento);
		this.endereco.add(endereco);
	}
	
	public void addEnderecoCobranca(String logradouro, String numero, Cidade cidade, String complemento) {
		this.addEndereco(logradouro, numero, cidade,TipoEndereco.COBRANCA, complemento);
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

//	public List<Conta> getConta() {
//		return conta;
//	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}

//	public void setConta(List<Conta> conta) {
//		this.conta = conta;
//	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public String getCpf() {
		return cpf;
	}

}

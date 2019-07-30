package com.db1.conta.contaapi.domain.entity;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class EnderecoTest {
	
	@Test
	public void deveRetornarClienteObrigatorio() {
		Cidade cidade = Mockito.mock(Cidade.class);
		String menssage = null;
		try {
			Endereco endereco = new Endereco(null, "Rua Pioneiro Jose tel","836",cidade,TipoEndereco.RESIDENCIAL,null);
		}catch (Exception e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Cliente obrigatório.", menssage);
	}
	
	@Test
	public void deveRetornarLogradouroObrigatorio() {
		Cidade cidade = Mockito.mock(Cidade.class);
		Cliente cliente = Mockito.mock(Cliente.class);
		String menssage = null;
		try {
			Endereco endereco = new Endereco(cliente, null,"836",cidade,TipoEndereco.RESIDENCIAL,null);
		}catch (Exception e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Nome do logradouro obrigatório.", menssage);
	}
	
	@Test
	public void deveRetornarNumeroObrigatorio() {
		Cidade cidade = Mockito.mock(Cidade.class);
		Cliente cliente = Mockito.mock(Cliente.class);
		String menssage = null;
		try {
			Endereco endereco = new Endereco(cliente,"Rua Pioneiro jose tel",null,cidade,TipoEndereco.RESIDENCIAL,null);
		}catch (Exception e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Número obrigatório.", menssage);
	}
	
	@Test
	public void deveRetornarCidadeObrigatorio() {
		Cliente cliente = Mockito.mock(Cliente.class);
		String menssage = null;
		try {
			Endereco endereco = new Endereco(cliente,"Rua Pioneiro jose tel","836",null,TipoEndereco.RESIDENCIAL,null);
		}catch (Exception e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Cidade obrigatória.", menssage);
	}
	
	@Test
	public void deveRetornarTipoEnderecoObrigatorio() {
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		String menssage = null;
		try {
			Endereco endereco = new Endereco(cliente,"Rua Pioneiro jose tel","836",cidade,null,null);
		}catch (Exception e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Tipo endereço obrigatório.", menssage);
	}
	
	@Test
	public void naoDeveRetornarException() {
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		String menssage = null;
		Endereco endereco = null;
		try {
			endereco = new Endereco(cliente,"Rua Pioneiro jose tel","836",cidade,TipoEndereco.RESIDENCIAL,null);
		}catch (Exception e) {
			menssage = e.getMessage();
		}
		Assert.assertNull(menssage);
		Assert.assertEquals(cliente,endereco.getCliente());
		Assert.assertEquals("Rua Pioneiro jose tel", endereco.getLogradouro());
		Assert.assertEquals("836", endereco.getNumero());
		Assert.assertEquals(cidade, endereco.getCidade());
		Assert.assertEquals(TipoEndereco.RESIDENCIAL, endereco.getTipoEndereco());
		Assert.assertEquals(null, endereco.getComplemento());
	}	
	

}

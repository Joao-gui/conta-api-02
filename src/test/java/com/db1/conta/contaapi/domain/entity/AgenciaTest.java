package com.db1.conta.contaapi.domain.entity;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


public class AgenciaTest {
	
	@Test
	public void deveRetornarNumeroObrigatorio() {
		Cidade cidade = Mockito.mock(Cidade.class);
		String menssage = null;
		try {
			Agencia agencia = new Agencia(null, "8", cidade);
		}catch (Exception e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Numero é obrigatório.", menssage);
	}
	
	@Test
	public void deveRetornarDigitoObrigatorio() {
		Cidade cidade = Mockito.mock(Cidade.class);
		String menssage = null;
		try {
			Agencia agencia = new Agencia("01552", null, cidade);
		}catch (Exception e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Digito é obrigatório.", menssage);
	}
	
	@Test
	public void deveRetornarCidadeObrigatorio() {
		String menssage = null;
		try {
			Agencia agencia = new Agencia("02154", "8", null);
		}catch (Exception e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Cidade é obrigatório.", menssage);
	}
	
	@Test
	public void naoDeveRetornarException() {
		Cidade cidade = Mockito.mock(Cidade.class);
		Agencia agencia = null;
		String menssage = null;
		try {
			 agencia = new Agencia("02154", "8", cidade);
		}catch (Exception e) {
			menssage = e.getMessage();
		}
		Assert.assertNull(menssage);
		Assert.assertEquals("02154", agencia.getNumero());
		Assert.assertEquals("8", agencia.getDigito());
		Assert.assertEquals(cidade, agencia.getCidade());
	}
}

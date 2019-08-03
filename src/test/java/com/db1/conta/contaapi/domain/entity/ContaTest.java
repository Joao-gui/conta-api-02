package com.db1.conta.contaapi.domain.entity;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


public class ContaTest {
	
	@Test
	public void deveRetornarAgenciaObrigatorio() {
		Cliente cliente = Mockito.mock(Cliente.class);
		String menssage = null;
		try {
			Conta conta = new Conta(null, ContaTIpo.CORRENTE, "0125", cliente);
		}catch (Exception e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Agencia é obrigatória.", menssage);
	}
	
	@Test
	public void deveRetornarContaTipoObrigatorio() {
		Cliente cliente = Mockito.mock(Cliente.class);
		Agencia agencia = Mockito.mock(Agencia.class);
		String menssage = null;
		try {
			Conta conta = new Conta(agencia, null, "0125", cliente);
		}catch (Exception e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Conta Tipo é obrigatório.", menssage);
	}
	
	@Test
	public void deveRetornarNumeroObrigatorio() {
		Cliente cliente = Mockito.mock(Cliente.class);
		Agencia agencia = Mockito.mock(Agencia.class);
		String menssage = null;
		try {
			Conta conta = new Conta(agencia, ContaTIpo.CORRENTE, null, cliente);
		}catch (Exception e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Numero é obrigatório.", menssage);
	}
	
	@Test
	public void deveRetornarClienteObrigatorio() {
		Agencia agencia = Mockito.mock(Agencia.class);
		String menssage = null;
		try {
			Conta conta = new Conta(agencia, ContaTIpo.CORRENTE, "0125", null);
		}catch (Exception e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Cliente é obrigatório.", menssage);
	}
	
	@Test
	public void naoDeveRetornarException() {
		Cliente cliente = Mockito.mock(Cliente.class);
		Agencia agencia = Mockito.mock(Agencia.class);
		String menssage = null;
		Conta conta = null;
		try {
			conta = new Conta(agencia, ContaTIpo.CORRENTE, "0125", cliente);
		}catch (Exception e) {
			menssage = e.getMessage();
		}
		Assert.assertNull(menssage);
		Assert.assertEquals(agencia, conta.getAgencia());
		Assert.assertEquals(ContaTIpo.CORRENTE, conta.getContaTipo());
		Assert.assertEquals("0125", conta.getNumero());
		Assert.assertEquals(cliente, conta.getCliente());
		Assert.assertEquals(0.0, conta.getSaldo(), 0.0);
	}

}

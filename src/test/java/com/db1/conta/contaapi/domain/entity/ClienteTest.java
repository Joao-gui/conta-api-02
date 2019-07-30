package com.db1.conta.contaapi.domain.entity;

import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {
	
	@Test
	public void deveRetornarNomeObrigatorio() {
		String menssage = null;
		Cliente cliente = null;
		try {
			cliente = new Cliente(null, "123500");
		}catch (Exception e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Nome é obrigatório.", menssage);
	}	
		
	@Test
	public void deveRetornarCpfObrigatorio() {
		String menssage = null;
		try {
			Cliente cliente = new Cliente("Joao", null);
		}catch (Exception e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("CPF é obrigatório.", menssage);
	}
	
	@Test
	public void naoDeveRetornarException() {
		String menssage = null;
		Cliente cliente = null;
		try {
			cliente = new Cliente("Joao", "010.456.825-87");
		}catch (Exception e) {
			menssage = e.getMessage();
		}
		Assert.assertNull(menssage);
		Assert.assertEquals("Joao", cliente.getNome());
		Assert.assertEquals("010.456.825-87", cliente.getCpf());
	}
	
	
}

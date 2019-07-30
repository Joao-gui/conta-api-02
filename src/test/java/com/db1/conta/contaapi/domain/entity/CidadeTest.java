package com.db1.conta.contaapi.domain.entity;


import org.junit.Assert;
import org.junit.Test;

public class CidadeTest {
	
	@Test
	public void deveRetornarNomeObrigatorio() {		
		String menssage = null;
		try {
			Cidade cidade = new Cidade(null, Estado.AC);
		}catch (Exception e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Nome é obrigatório.", menssage);
	}
	
	@Test
	public void deveRetornarEstadoObrigatorio() {
		String menssage = null;
		try {
			Cidade cidade = new Cidade("Maringá", null);
		}catch (Exception e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Estado é obrigatório.", menssage);
	}
	
	@Test
	public void naoDeveRetornarException() {
		String menssage = null;
		Cidade cidade = null;
		try {
			cidade = new Cidade("Maringá", Estado.PR);
		}catch (Exception e) {
			menssage = e.getMessage();
		}
		Assert.assertNull(menssage);
		Assert.assertEquals("Maringá", cidade.getNome());
		Assert.assertEquals(Estado.PR, cidade.getEstado());
	}	

}

package com.db1.conta.contaapi.domain.entity;

import java.time.LocalDateTime;

//import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;


public class HistoricoTest {
	
	@Test
	public void deveRetornarHistoricoTipoObrigatorio() {
		Conta conta = Mockito.mock(Conta.class);
		String menssage = null;
		try {
			Historico historico = new Historico(null,LocalDateTime.now(), 100.0, conta, 100.0);
		}catch (Exception e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Hitórico Tipo é obrigatório.", menssage);
	}
	
	@Test
	public void deveRetornarValorObrigatorio() {
		Conta conta = Mockito.mock(Conta.class);
		String menssage = null;
		try {
			Historico historico = new Historico(HistoricoTipo.ENTRADA,LocalDateTime.now(), null, conta, 100.0);
		}catch (Exception e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Valor é obrigatório.", menssage);
	}
	
	@Test
	public void deveRetornarContaObrigatorio() {		
		String menssage = null;
		try {
			Historico historico = new Historico(HistoricoTipo.ENTRADA,LocalDateTime.now(), 100.0, null, 100.0);
		}catch (Exception e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Conta é obrigatória.", menssage);
	}
	
	@Test
	public void deveRetornarValorResultanteObrigatorio() {
		Conta conta = Mockito.mock(Conta.class);
		String menssage = null;
		try {
			Historico historico = new Historico(HistoricoTipo.ENTRADA, LocalDateTime.now(), 100.0, conta, null);
		}catch (Exception e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Valor Resultante é obrigatório.", menssage);
	}
	
	 @Test
	public void deveRetornarDataObrigatorio() {
		Conta conta = Mockito.mock(Conta.class);
		String menssage = null;
		try {
			Historico historico = new Historico(HistoricoTipo.ENTRADA, null, 100.0, conta, 100.0);
		}catch (Exception e) {
			menssage = e.getMessage();
		}
		Assert.assertEquals("Data é obrigatória.", menssage);
	}
	 	
	
	@Test
	public void naoDeveRetornarException() {
		Conta conta = Mockito.mock(Conta.class);
		String menssage = null;
		Historico historico = null;
		try {
			historico = new Historico(HistoricoTipo.ENTRADA,LocalDateTime.now(), 100.0, conta, 100.0);
		}catch (Exception e) {
			menssage = e.getMessage();
		}
		Assert.assertNull(menssage);
		Assert.assertEquals(HistoricoTipo.ENTRADA, historico.getHistoricoTipo());
		Assert.assertEquals(100.0, historico.getValor(), 0.0);
		Assert.assertEquals(conta, historico.getConta());
		Assert.assertEquals(100.0, historico.getValorResultante(), 0.0);		
	}

}

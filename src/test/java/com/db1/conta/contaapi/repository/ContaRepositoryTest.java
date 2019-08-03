package com.db1.conta.contaapi.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1.conta.contaapi.domain.entity.Agencia;
import com.db1.conta.contaapi.domain.entity.Cidade;
import com.db1.conta.contaapi.domain.entity.Cliente;
import com.db1.conta.contaapi.domain.entity.Conta;
import com.db1.conta.contaapi.domain.entity.ContaTIpo;
import com.db1.conta.contaapi.domain.entity.Estado;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContaRepositoryTest {

	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private CidadeReposiroty cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private AgenciaRepository agenciaRepository;
	
	@After
	public void afterTest() {
		agenciaRepository.deleteAll();
		contaRepository.deleteAll();
		cidadeRepository.deleteAll();
		clienteRepository.deleteAll();
	}
	
	@Test
	public void deveSalvarUmaConta() {
		Cidade cidade = cidadeRepository.save(new Cidade("Maringá", Estado.PR));
		Agencia agencia = agenciaRepository.save(new Agencia("123456", "1", cidade));
		Cliente cliente = clienteRepository.save(new Cliente("Cliente Nome", "99999999999"));
		
		Conta conta = new  Conta(agencia, ContaTIpo.CORRENTE, "022120", cliente);
		
		Conta contaSalva = contaRepository.save(conta);
		
		Assert.assertEquals(conta.getNumero(), contaSalva.getNumero());
		Assert.assertNotNull(contaSalva.getId());
	}
	
	@Test
	public void deveSalvarUmaContaEUmHistorico() {
		Cidade cidade = cidadeRepository.save(new Cidade("Maringá", Estado.PR));
		Agencia agencia = agenciaRepository.save(new Agencia("123456", "1", cidade));
		Cliente cliente = clienteRepository.save(new Cliente("Cliente Nome", "99999999999"));
		
		Conta conta = new  Conta(agencia, ContaTIpo.CORRENTE, "022120", cliente);
		conta.depositar(10.0);
		Conta contaSalva = contaRepository.save(conta);
		
		Assert.assertEquals(conta.getNumero(), contaSalva.getNumero());
		Assert.assertNotNull(contaSalva.getId());
		Assert.assertEquals(1,contaSalva.getHistorico().size());
	}
}

package com.db1.conta.contaapi.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1.conta.contaapi.domain.entity.Cidade;
import com.db1.conta.contaapi.domain.entity.Cliente;
import com.db1.conta.contaapi.domain.entity.Estado;
import com.db1.conta.contaapi.domain.entity.TipoEndereco;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteRepositoryTest {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CidadeReposiroty cidadeRepository;

	@After
	public void afterTest() {
		clienteRepository.deleteAll();
		cidadeRepository.deleteAll();
	}
	@Test
	public void deveSalvarUmNovoCliente() {
		Cliente cliente = new Cliente("Nome do cliente", "99999999");		
				
		Cliente clienteSalvo = clienteRepository.save(cliente);		
		
		Assert.assertNotNull(clienteSalvo.getId());
		Assert.assertEquals(cliente.getNome(), clienteSalvo.getNome());
		Assert.assertEquals(cliente.getCpf(), clienteSalvo.getCpf());
		
	}
	@Test
	public void deveSalvarClienteComEndereco() {
		Cidade cidade = cidadeRepository.save(new Cidade("Maringá", Estado.PR));
		Cliente cliente = new Cliente("Nome Do Cliente", "99999999999");

		cliente.addEndereco("Rua A", "99",cidade, TipoEndereco.COBRANCA, "Casa" );

		Cliente clienteSalvo = clienteRepository.save(cliente);

		Assert.assertNotNull(clienteSalvo.getId());
		Assert.assertEquals(cliente.getCpf(), clienteSalvo.getCpf());
		Assert.assertEquals(cliente.getNome(), clienteSalvo.getNome());
		Assert.assertEquals(1, clienteSalvo.getEndereco().size());
		Assert.assertNotNull(clienteSalvo.getEndereco().get(0).getId());
	}

	
}

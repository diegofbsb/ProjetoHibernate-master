package br.pro.delfino.drogaria.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import br.pro.delfino.drogaria.domain.Cliente;
import br.pro.delfino.drogaria.domain.Pessoa;

public class ClienteDaoTest {

	@Test
	public void salver() throws ParseException {
		PessoaDao pessoDao = new PessoaDao();
		Pessoa pessoa = pessoDao.buscar(1L);

		Cliente cliente = new Cliente();

		cliente.setDataCadastro(new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2015"));
		cliente.setLiberado(true);
		cliente.setPessoa(pessoa);

		ClienteDao clienteDAO = new ClienteDao();
		clienteDAO.salvar(cliente);

		System.out.println("Cliente salvo com sucesso.");
	}
}
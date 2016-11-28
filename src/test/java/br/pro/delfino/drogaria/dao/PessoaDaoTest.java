package br.pro.delfino.drogaria.dao;

import org.junit.Test;

import br.pro.delfino.drogaria.domain.Cidade;
import br.pro.delfino.drogaria.domain.Pessoa;

public class PessoaDaoTest {

	@Test
	public void salvar() {
		Long codigo = 1L;
		
		PessoaDao pessoaDao = new PessoaDao();
		Pessoa pessoa = new Pessoa();

		CidadeDao cidadeDao = new CidadeDao();
		Cidade cidade = cidadeDao.buscar(codigo);
		
		pessoa.setBairro("Guará");
		pessoa.setCelular("982336352");
		pessoa.setCep("71010125");
		pessoa.setComplemento("207");
		pessoa.setCpf("04054635105");
		pessoa.setEmail("diego.fernando.santosbsb@gmail.com");
		pessoa.setNome("Diego");
		Short numero = 235;
		pessoa.setNumero(numero);
		pessoa.setRg("2949636");
		pessoa.setRua("rua04");
		pessoa.setTelefone("82336352");
		pessoa.setCidade(cidade);

		pessoaDao.salvar(pessoa);
		System.out.println("salvou");
	}

}

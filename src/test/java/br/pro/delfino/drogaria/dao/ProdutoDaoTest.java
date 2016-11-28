package br.pro.delfino.drogaria.dao;

import java.math.BigDecimal;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Fabricante;
import br.pro.delfino.drogaria.domain.Produto;

public class ProdutoDaoTest {

	@Test
	@Ignore
	public void salvar() {
		FabricanteDao fabricanteDAO = new FabricanteDao();
		Fabricante fabricante = fabricanteDAO.buscar(new Long("1"));

		Produto produto = new Produto();
		produto.setDescricao("Cataflan 50mg com 20 Comprimidos");
		produto.setFabricante(fabricante);
		produto.setPreco(new BigDecimal("13.70"));
		produto.setQuantidade(new Short("7"));

		ProdutoDao produtoDAO = new ProdutoDao();
		produtoDAO.salvar(produto);

		System.out.println("Produto salvo com sucesso");
	}
	
	
}

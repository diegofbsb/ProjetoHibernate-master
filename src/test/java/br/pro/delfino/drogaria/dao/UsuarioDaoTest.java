package br.pro.delfino.drogaria.dao;

import org.junit.Test;

import br.pro.delfino.drogaria.domain.Pessoa;
import br.pro.delfino.drogaria.domain.Usuario;

public class UsuarioDaoTest {
	
	@Test
	public void salvar(){
		PessoaDao pessoaDAO = new PessoaDao();
		Pessoa pessoa = pessoaDAO.buscar(1L);
		
		System.out.println("Pessoa Encontrada");
		System.out.println("Nome: " + pessoa.getNome());
		System.out.println("CPF: " + pessoa.getCpf());
		
		Usuario usuario = new Usuario();
		usuario.setAtiva(true);;
		usuario.setPessoa(pessoa);
		usuario.setSenha("root");
		usuario.setTipo('A');
		
		UsuarioDao usuarioDAO = new UsuarioDao();
		usuarioDAO.salvar(usuario);
		
		System.out.println("Usuário salvo com sucesso.");
	}
}

package br.pro.delfino.drogaria.dao;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Cidade;
import br.pro.delfino.drogaria.domain.Estado;

public class CidadeDaoTest {

	@Test
	@Ignore
	public void salvar() {

		Long codigoEstado = 1L;

		EstadoDao estadoDao = new EstadoDao();
		Estado estado = estadoDao.buscar(codigoEstado);

		Cidade cidade = new Cidade();
		cidade.setNome("Marilia");
		cidade.setEstado(estado);

		CidadeDao cidadeDao = new CidadeDao();
		cidadeDao.salvar(cidade);
	}

	@Test
	@Ignore
	public void listar() {

		Long codigo = 2L;

		CidadeDao cidadeDao = new CidadeDao();
		Cidade cidade = cidadeDao.buscar(codigo);

		System.out.println("Código da Cidade: " + cidade.getCodigo());
		System.out.println("Nome da Cidade: " + cidade.getNome());
		System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
		System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
		System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
	}

	@Test
	@Ignore
	public void editar() {
		Long codigoCidade = 2L;
		Long codigoEstado = 2L;

		EstadoDao estadoDao = new EstadoDao();
		Estado estado = estadoDao.buscar(codigoEstado);

		System.out.println("Código do Estado: " + estado.getCodigo());
		System.out.println("Sigla do Estado: " + estado.getSigla());
		System.out.println("Nome do Estado: " + estado.getNome());

		CidadeDao cidadeDao = new CidadeDao();
		Cidade cidade = cidadeDao.buscar(codigoCidade);

		System.out.println("Cidade A Ser Editada");
		System.out.println("Código da Cidade: " + cidade.getCodigo());
		System.out.println("Nome da Cidade: " + cidade.getNome());
		System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
		System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
		System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
	
		cidade.setNome("Guarapuava");
		cidade.setEstado(estado);
		
		cidadeDao.editar(cidade);
		
		System.out.println("Cidade Editada");
		System.out.println("Código da Cidade: " + cidade.getCodigo());
		System.out.println("Nome da Cidade: " + cidade.getNome());
		System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
		System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
		System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
		
	}
}

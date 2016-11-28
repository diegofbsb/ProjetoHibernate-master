package br.pro.delfino.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Estado;

public class EstadaoDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Estado estado = new Estado();
		estado.setNome("sao paulo");
		estado.setSigla("sp");

		EstadoDao estadoDao = new EstadoDao();
		estadoDao.salvar(estado);
	}

	@Test
	@Ignore
	public void listar() {

		EstadoDao estadoDao = new EstadoDao();
		List<Estado> resultado = estadoDao.listar();

		System.out.println("Total de Registro: " + resultado.size());

		for (Estado estado : resultado) {
			System.out.println("" + estado.getCodigo() + "-" + estado.getNome() + "-" + estado.getSigla());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 3L;
		EstadoDao estadoDao = new EstadoDao();
		Estado estado = estadoDao.buscar(codigo);

		System.out.println(estado);

		if (estado == null) {
			System.out.println("nulo, nao tem nada");
		} else {
			System.out.println("" + estado.getCodigo() + "-" + estado.getNome() + "-" + estado.getSigla());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 1L;
		EstadoDao estadoDao = new EstadoDao();
		Estado estado = estadoDao.buscar(codigo);

		if (estado == null) {
			System.out.println("nulo, nao tem nada");
		} else {
			estadoDao.excluir(estado);
			System.out.println("Excluiu a linha:" + codigo);
		}
	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 4L;
		EstadoDao estadoDao = new EstadoDao();
		Estado estado = estadoDao.buscar(codigo);

		if (estado == null) {
			System.out.println("nulo, nao tem nada");
		} else {
			estado.setNome("rio de janeiro");
			estado.setSigla("rj");
			estadoDao.editar(estado);
			System.out.println("" + estado.getCodigo() + "-" + estado.getNome() + "-" + estado.getSigla());
		}
	}
}

package br.pro.delfino.drogaria.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.pro.delfino.drogaria.util.HibernateUtil;

public class GenericDAO<Entidade> {

	private Class<Entidade> classe;

	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	// Salva os Dados
	public void salvar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.save(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}

	// Lista o Banco de Dados
	@SuppressWarnings("unchecked")
	public List<Entidade> listar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(classe);
			List<Entidade> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
	// Lista o Banco de Dados
		@SuppressWarnings("unchecked")
		public Entidade buscar(Long codigo) {
			Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
			try {
				Criteria consulta = sessao.createCriteria(classe);
				consulta.add(Restrictions.idEq(codigo));
				Entidade resultado = (Entidade)consulta.uniqueResult();
				return resultado;
			} catch (RuntimeException erro) {
				throw erro;
			} finally {
				sessao.close();
			}
		}
	
		// excluir os Dados
		public void excluir(Entidade entidade) {
			Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
			Transaction transacao = null;
			try {
				transacao = sessao.beginTransaction();
				sessao.delete(entidade);
				transacao.commit();
			} catch (RuntimeException erro) {
				if (transacao != null) {
					transacao.rollback();
				}
				throw erro;
			} finally {
				sessao.close();
			}
		}
		
		// Editar os Dados
				public void editar(Entidade entidade) {
					Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
					Transaction transacao = null;
					try {
						transacao = sessao.beginTransaction();
						sessao.update(entidade);
						transacao.commit();
					} catch (RuntimeException erro) {
						if (transacao != null) {
							transacao.rollback();
						}
						throw erro;
					} finally {
						sessao.close();
					}
				}
}
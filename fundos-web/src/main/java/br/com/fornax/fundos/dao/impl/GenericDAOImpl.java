package br.com.fornax.fundos.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.fundos.dao.GenericDAO;
import br.com.fornax.fundos.model.Cota;
import br.com.fornax.fundos.model.MovimentoFundo;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class GenericDAOImpl implements GenericDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void inserir(Object classe) {
		em.persist(classe);
	}

	@Override
	public void editar(Object classe) {
		em.merge(classe);
	}

	@Override
	public void excluir(Object classe) {
		em.remove(classe);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Object> listarTodos(String lista) {
		Query query = em.createQuery(lista);
		return query.getResultList();
	}

	@Override
	public List<Cota> listarCotasPorFundo(int id) {
		Query query = em.createQuery("select c from Cota c where c.fundo.id = :idFundo");
		query.setParameter("idFundo", id);
		return query.getResultList();
	}

	@Override
	public Cota listarCotaPorId(int id) {
		return em.find(Cota.class, id);
	}

	@Override
	public List<MovimentoFundo> listarMovimentosPorFundo(int id) {
		Query query = em.createQuery("select m from MovimentoFundo m where m.fundo.id = :idFundo");
		query.setParameter("idFundo", id);

		return query.getResultList();
	}

	@Override
	public MovimentoFundo buscarMovimentoPorIdFundoEIdMov(int idFundo, int idMov) {
		Query query = em.createQuery("select m from MovimentoFundo m where m.fundo.id = :idFundo and m.id = :idMov");
		query.setParameter("idFundo", idFundo);
		query.setParameter("idMov", idMov);
		
		return (MovimentoFundo) query.getResultList().get(0);
	}
}
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
		Query query = em.createQuery("select c from Cota c where c.fundo.id = :idCota");
		query.setParameter("idCota", id);
		return query.getResultList();
	}

	@Override
	public Cota listarCotaPorId(int id) {
		return em.find(Cota.class, id);
	}
}
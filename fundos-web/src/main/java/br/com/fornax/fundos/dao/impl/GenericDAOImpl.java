package br.com.fornax.fundos.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.fundos.dao.GenericDAO;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> listarTodos(int id) {
		return (List<Object>) em.find(Object.class, id);
	}
}
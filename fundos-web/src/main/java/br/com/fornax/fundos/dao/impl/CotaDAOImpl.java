package br.com.fornax.fundos.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.fundos.dao.CotaDAO;
import br.com.fornax.fundos.dao.GenericDAO;
import br.com.fornax.fundos.model.Cota;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class CotaDAOImpl extends GenericDAO implements CotaDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@SuppressWarnings("unchecked")
	public List<Cota> listarCotasPorFundo(int id) {
		Query query = em.createQuery("select c from Cota c where c.fundo.id = :idFundo");
		query.setParameter("idFundo", id);
		return query.getResultList();
	}
}
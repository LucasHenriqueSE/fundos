package br.com.fornax.fundos.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.fundos.dao.GenericDAO;
import br.com.fornax.fundos.dao.TipoDeFundoDAO;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class TipoDeFundoDAOImpl extends GenericDAO implements TipoDeFundoDAO {

	@PersistenceContext
	private EntityManager em;
}
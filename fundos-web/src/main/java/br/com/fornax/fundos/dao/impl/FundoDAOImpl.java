package br.com.fornax.fundos.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.fundos.dao.FundoDAO;
import br.com.fornax.fundos.dao.GenericDAO;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class FundoDAOImpl extends GenericDAO implements FundoDAO {

	@PersistenceContext
	private EntityManager em;	
}
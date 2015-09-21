package br.com.fornax.fundos.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.fundos.dao.GenericDAO;
import br.com.fornax.fundos.dao.TipoDeMovimentoFundoDAO;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class TipoDeMovimentoFundoDAOImpl extends GenericDAO implements TipoDeMovimentoFundoDAO {

	@PersistenceContext
	private EntityManager em;
}
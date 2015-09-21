package br.com.fornax.fundos.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.fundos.dao.GenericDAO;
import br.com.fornax.fundos.dao.MovimentoFundoDAO;
import br.com.fornax.fundos.model.MovimentoFundo;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class MovimentoFundoDAOImpl extends GenericDAO implements MovimentoFundoDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<MovimentoFundo> listarMovimentosPorFundo(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovimentoFundo buscarMovimentoPorIdFundoEIdMov(int idFundo, int idMov) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
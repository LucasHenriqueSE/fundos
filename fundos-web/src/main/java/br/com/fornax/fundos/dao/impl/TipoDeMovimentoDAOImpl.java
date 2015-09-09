package br.com.fornax.fundos.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.fundos.dao.TipoDeMovimentoDAO;
import br.com.fornax.fundos.model.TipoDeMovimentoFundo;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class TipoDeMovimentoDAOImpl implements TipoDeMovimentoDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void inserir(TipoDeMovimentoFundo tipoDeMovimentoFundo) {
		em.persist(tipoDeMovimentoFundo);

	}

	@Override
	public void editar(TipoDeMovimentoFundo tipoDeMovimentoFundo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(TipoDeMovimentoFundo tipoDeMovimentoFundo) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TipoDeMovimentoFundo> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}

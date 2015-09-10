package br.com.fornax.fundos.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.fundos.dao.GenericDAO;
import br.com.fornax.fundos.model.TipoDeMovimentoFundo;
import br.com.fornax.fundos.services.TipoDeMovimentoFundoService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TipoDeMovimentoFundoServiceImpl implements TipoDeMovimentoFundoService {

	@Inject
	private GenericDAO dao;

	@Override
	public Boolean inserir(TipoDeMovimentoFundo tipo) {
		dao.inserir(tipo);
		return null;
	}

	@Override
	public Boolean alterar(TipoDeMovimentoFundo tipo) {
		dao.editar(tipo);
		return null;
	}
	
	@Override
	public Boolean excluir(TipoDeMovimentoFundo tipo) {
		dao.excluir(tipo);
		return null;
	}

	@Override
	public List<TipoDeMovimentoFundo> listarTodos(int id) {
		dao.listarTodos(id);
		return null;
	}
}
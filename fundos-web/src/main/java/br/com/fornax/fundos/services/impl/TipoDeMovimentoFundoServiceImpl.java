package br.com.fornax.fundos.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.fundos.dao.TipoDeMovimentoFundoDAO;
import br.com.fornax.fundos.model.TipoDeMovimentoFundo;
import br.com.fornax.fundos.services.TipoDeMovimentoFundoService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TipoDeMovimentoFundoServiceImpl implements
		TipoDeMovimentoFundoService {

	@Inject
	private TipoDeMovimentoFundoDAO dao;

	@Override
	public Boolean inserir(TipoDeMovimentoFundo tipoDeMovimentoFundo) {
		try {
			dao.inserir(tipoDeMovimentoFundo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean editar(TipoDeMovimentoFundo tipoDeMovimentoFundo) {
		dao.editar(tipoDeMovimentoFundo);
		return null;
	}

	@Override
	public Boolean excluir(TipoDeMovimentoFundo tipoDeMovimentoFundo) {
		Boolean excluiu = false;
		if (tipoDeMovimentoFundo.getListaMovimentos().isEmpty()) {
			dao.excluir(tipoDeMovimentoFundo);
			return excluiu = true;
		}
		return excluiu;
	}

	@Override
	public List<Object> listarTodos() {
		return dao.listarTodos("select t from TipoDeMovimentoFundo t");
	}

	@Override
	public TipoDeMovimentoFundo listarPorId(int id) {
		return (TipoDeMovimentoFundo) dao.listarPorId(
				new TipoDeMovimentoFundo(), id);
	}
}
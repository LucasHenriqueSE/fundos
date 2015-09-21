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
public class TipoDeMovimentoFundoServiceImpl implements TipoDeMovimentoFundoService {

	@Inject
	private TipoDeMovimentoFundoDAO dao;

	@Override
	public Boolean inserir(TipoDeMovimentoFundo tipo) {
		try {
			dao.inserir(tipo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean editar(TipoDeMovimentoFundo tipo) {
		dao.editar(tipo);
		return null;
	}
	
	@Override
	public Boolean excluir(TipoDeMovimentoFundo tipo) {
		dao.excluir(tipo);
		return null;
	}

	@Override
	public List<Object> listarTodos() {
		return dao.listarTodos("select t from TipoDeMovimentoFundo t");
	}
}
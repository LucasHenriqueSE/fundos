package br.com.fornax.fundos.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.fundos.dao.GenericDAO;
import br.com.fornax.fundos.model.MovimentoFundo;
import br.com.fornax.fundos.services.MovimentoFundoService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class MovimentoFundoServiceImpl implements MovimentoFundoService {

	@Inject
	GenericDAO dao;
	
	@Override
	public Boolean inserir(MovimentoFundo movimentoFundo) {
		try {
			dao.inserir(movimentoFundo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean editar(MovimentoFundo movimentoFundo) {
		dao.editar(movimentoFundo);
		return null;
	}

	@Override
	public Boolean excluir(MovimentoFundo movimentoFundo) {
		dao.excluir(movimentoFundo);
		return null;
	}

	@Override
	public List<Object> listarTodos() {
		return dao.listarTodos("select m from MovimentoFundo m");
		
	}
}
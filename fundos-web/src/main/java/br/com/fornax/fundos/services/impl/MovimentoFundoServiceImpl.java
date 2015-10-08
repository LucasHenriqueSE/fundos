package br.com.fornax.fundos.services.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.fundos.dao.MovimentoFundoDAO;
import br.com.fornax.fundos.model.MovimentoFundo;
import br.com.fornax.fundos.services.MovimentoFundoService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class MovimentoFundoServiceImpl implements MovimentoFundoService {

	@Inject
	private MovimentoFundoDAO dao;

	@Override
	public Boolean inserir(MovimentoFundo movimentoFundo) {
		try {
			Date data = new Date();
			movimentoFundo.setDataMovimentoFundo(data);
			dao.inserir(movimentoFundo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean editar(MovimentoFundo movimentoFundo) {
		Date data = new Date();
		movimentoFundo.setDataMovimentoFundo(data);
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

	@Override
	public List<MovimentoFundo> listarMovimentosPorFundo(int id) {
		return dao.listarMovimentosPorFundo(id);
	}

	@Override
	public MovimentoFundo buscarMovimentoPorIdFundoEIdMov(int idFundo, int idMov) {
		return dao.buscarMovimentoPorIdFundoEIdMov(idFundo, idMov);
	}

	@Override
	public Object listarPorId(Object object, int idMovimento) {
		return dao.listarPorId(object, idMovimento);
	}
}
package br.com.fornax.fundos.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	public Boolean inserir(MovimentoFundo movimentoFundo, String dataCadastro) {
		try {
			movimentoFundo.setDataMovimentoFundo(convertData(dataCadastro));
			dao.inserir(movimentoFundo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private Date convertData(String dataCadastro) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Date date = null;
		
		try {
			date = formatter.parse(dataCadastro);

			System.out.println(date);
			System.out.println(formatter.format(date));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	@Override
	public Boolean editar(MovimentoFundo movimentoFundo, String dataCadastro) {
		movimentoFundo.setDataMovimentoFundo(convertData(dataCadastro));
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
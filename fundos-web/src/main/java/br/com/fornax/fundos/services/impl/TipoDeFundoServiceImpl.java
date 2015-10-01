package br.com.fornax.fundos.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.fundos.dao.TipoDeFundoDAO;
import br.com.fornax.fundos.model.TipoDeFundo;
import br.com.fornax.fundos.services.TipoDeFundoService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TipoDeFundoServiceImpl implements TipoDeFundoService {

	@Inject
	private TipoDeFundoDAO dao;

	@Override
	public Boolean inserir(TipoDeFundo tipoDeFundo) {
		try {
			dao.inserir(tipoDeFundo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean editar(TipoDeFundo tipoDeFundo) {
		dao.editar(tipoDeFundo);
		return null;
	}

	@Override
	public Boolean excluir(TipoDeFundo tipoDeFundo) {
		Boolean excluiu = false;
		if(tipoDeFundo.getListaFundos().isEmpty()){
			dao.excluir(tipoDeFundo);
			excluiu = true;
		}
		return excluiu;
	}

	@Override
	public List<Object> listarTodos() {
		return dao.listarTodos("select t from TipoDeFundo t"); 
	}
	
	@Override
	public TipoDeFundo listarPorId(int id) {
		return (TipoDeFundo) dao.listarPorId(new TipoDeFundo(), id);
	}
}
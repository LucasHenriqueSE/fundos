package br.com.fornax.fundos.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.fundos.dao.GenericDAO;
import br.com.fornax.fundos.model.TipoDeFundo;
import br.com.fornax.fundos.services.TipoDeFundoService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TipoDeFundoServiceImpl implements TipoDeFundoService {

	@Inject
	GenericDAO dao;

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
		dao.excluir(tipoDeFundo);
		return null;
	}

	@Override
	public List<Object> listarTodos() {
		return dao.listarTodos("select t from TipoDeFundo t"); 
	}
}
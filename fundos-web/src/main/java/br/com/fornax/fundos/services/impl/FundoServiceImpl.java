package br.com.fornax.fundos.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.fundos.dao.GenericDAO;
import br.com.fornax.fundos.model.Fundo;
import br.com.fornax.fundos.services.FundoService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class FundoServiceImpl implements FundoService {

	@Inject
	GenericDAO dao;

	@Override
	public Boolean inserir(Fundo fundo) {
		dao.inserir(fundo);
		return null;
	}

	@Override
	public Boolean editar(Fundo fundo) {
		dao.editar(fundo);
		return null;
	}

	@Override
	public Boolean excluir(Fundo fundo) {
		dao.excluir(fundo);
		return null;
	}

	@Override
	public List<Fundo> listaTodos(int id) {
		dao.listarTodos(id);
		return null;
	}
}
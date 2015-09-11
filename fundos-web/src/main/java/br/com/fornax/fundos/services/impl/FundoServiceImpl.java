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
		try {
			dao.inserir(fundo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
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
	public List<Object> listaTodos() {
		return dao.listarTodos("select f from Fundo f");
	}
}
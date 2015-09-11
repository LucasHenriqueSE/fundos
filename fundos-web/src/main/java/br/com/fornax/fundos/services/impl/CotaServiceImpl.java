package br.com.fornax.fundos.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.fundos.dao.GenericDAO;
import br.com.fornax.fundos.model.Cota;
import br.com.fornax.fundos.services.CotaService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CotaServiceImpl implements CotaService {

	@Inject
	GenericDAO dao;

	@Override
	public Boolean inserir(Cota cota) {
		dao.inserir(cota);
		return null;
	}

	@Override
	public Boolean alterar(Cota cota) {
		dao.editar(cota);
		return null;
	}

	@Override
	public Boolean excluir(Cota cota) {
		dao.excluir(cota);
		return null;
	}

	@Override
	public List<Object> listarTodas() {
		return dao.listarTodos("select c from Cota c");
	}
}
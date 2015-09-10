package br.com.fornax.fundos.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.fundos.dao.GenericDAO;
import br.com.fornax.fundos.model.TipoDeMovimentoFundo;
import br.com.fornax.fundos.services.TipoDeMovimentoService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TipoDeMovimentoServiceImpl implements TipoDeMovimentoService {

	@Inject
	private GenericDAO dao;

	@Override
	public Boolean inserir(TipoDeMovimentoFundo tipo) {
		dao.inserir(tipo);
		return null;
	}

	@Override
	public Boolean alterar(TipoDeMovimentoFundo tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoDeMovimentoFundo> listarTodos() {
		TipoDeMovimentoFundo tipo1 = new TipoDeMovimentoFundo();
		TipoDeMovimentoFundo tipo2 = new TipoDeMovimentoFundo();
		TipoDeMovimentoFundo tipo3 = new TipoDeMovimentoFundo();

		tipo1.setId(0);
		tipo1.setNomeTipoMovimentoFundo("Tipo 1");

		tipo2.setId(1);
		tipo2.setNomeTipoMovimentoFundo("Tipo 2");

		tipo3.setId(2);
		tipo3.setNomeTipoMovimentoFundo("Tipo 3");

		List<TipoDeMovimentoFundo> listaTipo;

		listaTipo = new ArrayList<TipoDeMovimentoFundo>();

		listaTipo.add(tipo1);
		listaTipo.add(tipo2);
		listaTipo.add(tipo3);

		return listaTipo;
	}

}
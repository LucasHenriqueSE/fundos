package br.com.fornax.fundos.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fornax.fundos.model.TipoDeMovimentoFundo;
import br.com.fornax.fundos.services.TipoDeMovimentoService;

@Service
public class TipoDeMovimentoServiceImpl implements TipoDeMovimentoService {

	@Override
	public Boolean inserir(TipoDeMovimentoFundo tipo) {
		// TODO Auto-generated method stub
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
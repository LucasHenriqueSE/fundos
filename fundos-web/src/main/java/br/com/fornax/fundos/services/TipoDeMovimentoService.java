package br.com.fornax.fundos.services;

import java.util.List;

import br.com.fornax.fundos.model.TipoDeMovimentoFundo;

public interface TipoDeMovimentoService {
	Boolean inserir(TipoDeMovimentoFundo tipo);
	
	Boolean alterar(TipoDeMovimentoFundo tipo);
	
	List<TipoDeMovimentoFundo> listarTodos();
}

package br.com.fornax.fundos.services;

import java.util.List;

import br.com.fornax.fundos.model.TipoDeMovimentoFundo;

public interface TipoDeMovimentoFundoService {
	
	Boolean inserir(TipoDeMovimentoFundo tipoDeMovimentoFundo);

	Boolean editar(TipoDeMovimentoFundo tipoDeMovimentoFundo);

	Boolean excluir(TipoDeMovimentoFundo tipoDeMovimentoFundo);

	List<Object> listarTodos();
}
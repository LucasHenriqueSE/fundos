package br.com.fornax.fundos.dao;

import java.util.List;

import br.com.fornax.fundos.model.TipoDeMovimentoFundo;

public interface TipoDeMovimentoDAO {
	
	void inserir(TipoDeMovimentoFundo tipoDeMovimentoFundo);

	void editar(TipoDeMovimentoFundo tipoDeMovimentoFundo);

	void excluir(TipoDeMovimentoFundo tipoDeMovimentoFundo);

	List<TipoDeMovimentoFundo> listarTodos();
}

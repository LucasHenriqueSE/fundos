package br.com.fornax.fundos.services;

import java.util.List;

import br.com.fornax.fundos.model.MovimentoFundo;

public interface MovimentoFundoService {

	Boolean inserir(MovimentoFundo movimentoFundo);

	Boolean alterar(MovimentoFundo movimentoFundo);

	Boolean excluir(MovimentoFundo movimentoFundo);

	List<Object> listarTodos();
}

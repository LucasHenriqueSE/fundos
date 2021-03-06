package br.com.fornax.fundos.services;

import java.util.List;

import br.com.fornax.fundos.model.Fundo;

public interface FundoService {

	Boolean inserir(Fundo fundo);

	Boolean editar(Fundo fundo);

	Boolean excluir(Fundo fundo);

	List<Object> listarTodos();

	Fundo listarPorId(int id);
}

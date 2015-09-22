package br.com.fornax.fundos.services;

import java.util.List;

import br.com.fornax.fundos.model.TipoDeFundo;

public interface TipoDeFundoService {

	Boolean inserir(TipoDeFundo tipoDeFundo);

	Boolean editar(TipoDeFundo tipoDeFundo);

	Boolean excluir(TipoDeFundo tipoDeFundo);

	List<Object> listarTodos();

	TipoDeFundo listarPorId(int id);
}
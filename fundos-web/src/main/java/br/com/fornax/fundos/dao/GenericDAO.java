package br.com.fornax.fundos.dao;

import java.util.List;

public interface GenericDAO {
	
	void inserir(Object classe);

	void editar(Object classe);

	void excluir(Object classe);

	List<Object> listarTodos(int id);
}
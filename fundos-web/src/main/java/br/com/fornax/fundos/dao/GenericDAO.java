package br.com.fornax.fundos.dao;

import java.util.List;

import br.com.fornax.fundos.model.Cota;

public interface GenericDAO {
	
	void inserir(Object classe);

	void editar(Object classe);

	void excluir(Object classe);

	List<Object> listarTodos(String query);

	List<Cota> listarCotasPorFundo(int id);

	Cota listarCotaPorId(int id);
}
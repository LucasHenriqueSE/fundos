package br.com.fornax.fundos.dao;

import java.util.List;

public interface TipoDeFundoDAO {
	
	public void inserir(Object object);

	public void editar(Object object);

	public void excluir(Object object);

	public List<Object> listarTodos(String queryString);

	public Object listarPorId(Object object, int id);
}
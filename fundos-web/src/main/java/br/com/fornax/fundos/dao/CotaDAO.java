package br.com.fornax.fundos.dao;

import java.util.List;

import br.com.fornax.fundos.model.Cota;

public interface CotaDAO {

	public void inserir(Object object);

	public void editar(Object object);

	public void excluir(Object object);

	public List<Object> listarTodos(String queryString);

	public Object listarPorId(Object object, int id);

	List<Cota> listarCotasPorFundo(int id);
}

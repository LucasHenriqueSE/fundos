package br.com.fornax.fundos.dao;

import java.util.List;

import br.com.fornax.fundos.model.MovimentoFundo;

public interface MovimentoFundoDAO {
	
	public void inserir(Object object);

	public void editar(Object object);

	public void excluir(Object object);

	public List<Object> listarTodos(String queryString);

	public Object listarPorId(Object object, int id);
	
	List<MovimentoFundo> listarMovimentosPorFundo(int id);

	MovimentoFundo buscarMovimentoPorIdFundoEIdMov(int idFundo, int idMov);

}

package br.com.fornax.fundos.services;

import java.util.List;

import br.com.fornax.fundos.model.Cota;

public interface CotaService {
	Boolean inserir(Cota cota);

	Boolean editar(Cota cota, String dataCadastro);

	Boolean excluir(Cota cota);

	List<Object> listarTodas();

	List<Cota> listarCotasPorFundo(int id);

	Cota listarCotaPorId(int id);
}
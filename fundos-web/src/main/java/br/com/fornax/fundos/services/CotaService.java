package br.com.fornax.fundos.services;

import java.util.List;

import br.com.fornax.fundos.model.Cota;

public interface CotaService {
	Boolean inserir(Cota cota);

	Boolean editar(Cota cota);

	Boolean excluir(Cota cota);

	List<Object> listarTodas();

	List<Cota> listarCotasPorFundo(int idFundo);

	Cota buscarCotaPorId(int idCota);
}
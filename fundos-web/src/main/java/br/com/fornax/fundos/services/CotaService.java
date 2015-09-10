package br.com.fornax.fundos.services;

import java.util.List;

import br.com.fornax.fundos.model.Cota;

public interface CotaService {
	Boolean inserir(Cota cota);

	Boolean alterar(Cota cota);

	Boolean excluir(Cota cota);

	List<Cota> listarTodas(int id);
}
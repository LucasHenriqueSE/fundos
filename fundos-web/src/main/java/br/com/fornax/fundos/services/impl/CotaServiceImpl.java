package br.com.fornax.fundos.services.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.fundos.dao.CotaDAO;
import br.com.fornax.fundos.model.Cota;
import br.com.fornax.fundos.services.CotaService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CotaServiceImpl implements CotaService {

	@Inject
	private CotaDAO dao;

	@Override
	public Boolean inserir(Cota cota) {
		Date data = new Date();
		cota.setData(data);
		dao.inserir(cota);
		return null;
	}

	@Override
	public Boolean editar(Cota cota) {
		Date data = new Date();
		cota.setData(data);
		dao.editar(cota);
		return null;
	}

	@Override
	public Boolean excluir(Cota cota) {
		try {
			dao.excluir(cota);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Object> listarTodas() {
		return dao.listarTodos("select c from Cota c");
	}

	@Override
	public List<Cota> listarCotasPorFundo(int id) {
		return dao.listarCotasPorFundo(id);

	}

	@Override
	public Cota buscarCotaPorId(int idCota) {
		return (Cota) dao.listarPorId(new Cota(), idCota);
	}
}
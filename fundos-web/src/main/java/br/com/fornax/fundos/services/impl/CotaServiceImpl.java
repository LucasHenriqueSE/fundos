package br.com.fornax.fundos.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		try {
			dao.inserir(cota);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean editar(Cota cota, String dataCadastro) {
		cota.setData(convertData(dataCadastro));
		dao.editar(cota);
		return null;
	}

	private Date convertData(String dataCadastro) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Date date = null;
		
		try {
			date = formatter.parse(dataCadastro);

			System.out.println(date);
			System.out.println(formatter.format(date));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	@Override
	public Boolean excluir(Cota cota) {
		dao.excluir(cota);
		return null;
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
		return (Cota) dao.listarPorId(new Cota(),idCota);
	}
}
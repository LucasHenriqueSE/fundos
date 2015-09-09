package br.com.fornax.fundos.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fornax.fundos.model.MovimentoFundo;
import br.com.fornax.fundos.model.TipoDeMovimentoFundo;
import br.com.fornax.fundos.services.TipoDeMovimentoService;

@Controller
@RequestMapping("movimentos")
public class MovimentoController {

	@Inject
	private TipoDeMovimentoService tipoDeMovimentoService;

	@RequestMapping("tipos-de-movimentos")
	public String tiposDeMovimentos() {
		// 
		for (TipoDeMovimentoFundo t : tipoDeMovimentoService.listarTodos()) {
			System.out.println("ID: " + t.getId() + "\nNome: "
					+ t.getNomeTipoMovimentoFundo());
		}

		return "";
	}

	@RequestMapping("cadastrar")
	public String cadastrarNovoMovimentoFundo() {
		return "novo-movimento-fundo";
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvarNovoMovimentoFundo(MovimentoFundo novo) {
		System.out.println(novo.getQtdMovimentoFundo() + "\n"
				+ novo.getQtdMovimentoFundo() + "\n"
				+ novo.getValorCotaMovimentoFundo());

		return "novo-movimento-fundo";
	}

	@RequestMapping("tipo-movimento/cadastrar")
	public String cadastrarTipoMovimentoFundos() {
		return "novo-tipo-movimento-fundos";
	}

	@RequestMapping(value = "tipo-movimento/salvar", method = RequestMethod.POST)
	public String salvarTipoMovimentoFundos(TipoDeMovimentoFundo novo) {
		System.out.println(novo.getNomeTipoMovimentoFundo());

		return "novo-tipo-movimento-fundos";
	}
}
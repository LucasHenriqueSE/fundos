package br.com.fornax.fundos.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fornax.fundos.model.Fundo;
import br.com.fornax.fundos.model.TipoDeFundo;
import br.com.fornax.fundos.services.FundoService;
import br.com.fornax.fundos.services.TipoDeFundoService;

@Controller
public class FundoController {

	@Inject
	private FundoService fundoService;

	@Inject
	private TipoDeFundoService tipoDeFundoService;

	@RequestMapping("cadastrar")
	public String cadastrarNovoFundo() {
		return "novo-fundo";
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvarNovoFundo(Fundo novo) {
		fundoService.inserir(novo);

		return "novo-fundo";
	}

	@RequestMapping("tipo-de-fundo/cadastrar")
	public String cadastrarTipoDeFundo() {
		return "novo-tipo-fundo";
	}

	@RequestMapping(value = "tipo-de-fundo/salvar", method = RequestMethod.POST)
	public String salvarTipoDeFundo(TipoDeFundo novo) {
		tipoDeFundoService.inserir(novo);

		return "novo-tipo-fundo";
	}
}
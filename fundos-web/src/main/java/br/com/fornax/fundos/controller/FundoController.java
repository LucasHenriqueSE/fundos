package br.com.fornax.fundos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fornax.fundos.model.Fundo;
import br.com.fornax.fundos.model.TipoDeFundo;

@Controller
public class FundoController {

	@RequestMapping("cadastrar")
	public String cadastrarNovoFundo() {
		return "novo-fundo";
	}
	
	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvarNovoFundo(Fundo novo) {
		System.out.println(novo.getNome() + "\n" + novo.getTipoFundo() + "\n"
				+ novo.getListaCotas() + "\n" + novo.getListaMovimentos());
		
		return "novo-fundo";
	}

	@RequestMapping("tipo-de-fundo/cadastrar")
	public String cadastrarTipoDeFundo() {
		return "novo-tipo-fundo";
	}

	@RequestMapping(value = "tipo-de-fundo/salvar", method = RequestMethod.POST)
	public String salvarTipoDeFundo(TipoDeFundo novo) {
		System.out.println(novo.getNomeTipoFundo());

		return "novo-tipo-fundo";
	}
}
package br.com.fornax.fundos.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fornax.fundos.model.Cota;
import br.com.fornax.fundos.services.CotaService;

@Controller
@RequestMapping("cota")
public class CotaController {
	
	@Inject
	private CotaService cotaService;

	@RequestMapping("cadastrar")
	public String cadastrarCota() {
		return "nova-cota";
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvarCota(Cota nova) {
		cotaService.inserir(nova);

		return "";
	}
}
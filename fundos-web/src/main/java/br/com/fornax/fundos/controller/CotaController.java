package br.com.fornax.fundos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fornax.fundos.model.Cota;

@Controller
@RequestMapping("cota")
public class CotaController {

	@RequestMapping("cadastrar")
	public String cadastrarCota() {
		return "nova-cota";
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvarCota(Cota novo) {
		System.out.println("Valor: " + novo.getValor());

		return "nova-cota";
	}
}
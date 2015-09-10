package br.com.fornax.fundos.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fornax.fundos.model.MovimentoFundo;
import br.com.fornax.fundos.model.TipoDeMovimentoFundo;
import br.com.fornax.fundos.services.MovimentoFundoService;
import br.com.fornax.fundos.services.TipoDeMovimentoFundoService;

@Controller
@RequestMapping("movimentos")
public class MovimentoController {

	@Inject
	private MovimentoFundoService movimentoFundoService;

	@Inject
	private TipoDeMovimentoFundoService tipoDeMovimentoFundoService;

	@RequestMapping("cadastrar")
	public String cadastrarNovoMovimentoFundo() {
		return "novo-movimento-fundo";
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvarNovoMovimentoFundo(MovimentoFundo novo) {
		movimentoFundoService.inserir(novo);

		return "novo-movimento-fundo";
	}

	@RequestMapping("tipo-movimento/cadastrar")
	public String cadastrarTipoMovimentoFundos() {
		return "novo-tipo-movimento-fundos";
	}

	@RequestMapping(value = "tipo-movimento/salvar", method = RequestMethod.POST)
	public String salvarTipoMovimentoFundos(TipoDeMovimentoFundo novo) {
		tipoDeMovimentoFundoService.inserir(novo);

		return "novo-tipo-movimento-fundos";
	}
}
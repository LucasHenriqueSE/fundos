package br.com.fornax.fundos.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.fornax.fundos.model.TipoDeMovimentoFundo;
import br.com.fornax.fundos.services.TipoDeMovimentoFundoService;

@Controller
public class TipoMovimentoController {

	@Inject
	private TipoDeMovimentoFundoService tipoDeMovimentoFundoService;

	private ModelAndView mav = new ModelAndView();

	@RequestMapping("tipo-movimento")
	public ModelAndView listarTipoDeMovimentos() {
		mav = new ModelAndView();
		mav.addObject("tipos", tipoDeMovimentoFundoService.listarTodos());
		mav.setViewName("listar-tipo-de-movimento");
		return mav;
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

	@RequestMapping("tipo-movimento/{id}/editar")
	public ModelAndView editarTipoMovimentoFundos(@PathVariable("id") int id) {
		mav = new ModelAndView();
		TipoDeMovimentoFundo tipoDeMovimentoFundo = tipoDeMovimentoFundoService.listarPorId(id);

		mav.addObject("tipo", tipoDeMovimentoFundo);
		mav.setViewName("editar-tipo-movimento-fundos");
		return mav;
	}

	@RequestMapping("tipo-movimento/alterar")
	public String alterarTipoMovimentoFundos(TipoDeMovimentoFundo tipoDeMovimentoFundo) {
		tipoDeMovimentoFundoService.editar(tipoDeMovimentoFundo);
		return "redirect:/tipo-movimento";
	}

	@RequestMapping("tipo-movimento/{idTipo}/excluir")
	public String excluirTipoMovimento(@PathVariable("idTipo") int idTipo) {
		TipoDeMovimentoFundo tipoDeMovimentoFundo = tipoDeMovimentoFundoService.listarPorId(idTipo);
		tipoDeMovimentoFundoService.excluir(tipoDeMovimentoFundo);
		return "redirect:/tipo-movimento";
	}
}
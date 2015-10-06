package br.com.fornax.fundos.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.fornax.fundos.model.MovimentoFundo;
import br.com.fornax.fundos.services.MovimentoFundoService;
import br.com.fornax.fundos.services.TipoDeMovimentoFundoService;

@Controller
@RequestMapping("movimentos")
public class MovimentoController {

	@Inject
	private MovimentoFundoService movimentoFundoService;

	@Inject
	private TipoDeMovimentoFundoService tipoDeMovimentoFundoService;

	private ModelAndView mav;

	@RequestMapping("{idFundo}/cadastrar")
	public ModelAndView cadastrarNovoMovimentoFundo(
			@PathVariable("idFundo") int idFundo) {
		mav = new ModelAndView();

		mav.setViewName("novo-movimento-fundo");
		mav.addObject("tipos", tipoDeMovimentoFundoService.listarTodos());
		mav.addObject("idFundo", idFundo);
		return mav;
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvarNovoMovimentoFundo(MovimentoFundo movimentoFundo,
			String dataCadastro) {
		movimentoFundoService.inserir(movimentoFundo, dataCadastro);
		return "redirect:/fundo/" + movimentoFundo.getFundo().getId()
				+ "/movimentos";
	}

	@RequestMapping("alterar")
	public String alterar(MovimentoFundo movimentoFundo, String dataCadastro) {
		movimentoFundoService.editar(movimentoFundo, dataCadastro);
		return "redirect:/fundo/" + movimentoFundo.getFundo().getId()
				+ "/movimentos";
	}

	@RequestMapping("{movimento.fundo.id}/movimento/{movimento.id}")
	public ModelAndView editar(@PathVariable("movimento.fundo.id") int idFundo,
			@PathVariable("movimento.id") int idMovimento) {
		MovimentoFundo movimentoFundo;
		mav = new ModelAndView();

		movimentoFundo = movimentoFundoService.buscarMovimentoPorIdFundoEIdMov(
				idFundo, idMovimento);

		mav.setViewName("editar-movimento-fundo");
		mav.addObject("tipos", tipoDeMovimentoFundoService.listarTodos());
		mav.addObject("movimentoFundo", movimentoFundo);
		return mav;
	}

	@RequestMapping("{idFundo}/movimento/{idMovimento}/excluir")
	public String excluirMovimento(
			@PathVariable("idMovimento") int idMovimento,
			@PathVariable("idFundo") int idFundo) {
		MovimentoFundo movimento = movimentoFundoService
				.buscarMovimentoPorIdFundoEIdMov(idFundo, idMovimento);
		movimentoFundoService.listarPorId(movimento, idMovimento);
		movimentoFundoService.excluir(movimento);
		return "redirect:/fundo/{idFundo}/movimentos";
	}
}
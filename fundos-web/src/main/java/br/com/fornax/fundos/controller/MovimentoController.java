package br.com.fornax.fundos.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	private ModelAndView mav;

	@RequestMapping("cadastrar/{idFundo}")
	public ModelAndView cadastrarNovoMovimentoFundo(@PathVariable("idFundo") int idFundo) {
		mav = new ModelAndView();
		
		mav.setViewName("novo-movimento-fundo");
		mav.addObject("tipos", tipoDeMovimentoFundoService.listarTodos());
		mav.addObject("idFundo", idFundo);
		return mav;
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvarNovoMovimentoFundo(MovimentoFundo novo, String dataCadastro) {
		movimentoFundoService.inserir(novo, dataCadastro);

		return "novo-movimento-fundo";
	}
	
	@RequestMapping("alterar")
	public String alterar(MovimentoFundo movimentoFundo, String dataCadastro){
		movimentoFundoService.editar(movimentoFundo, dataCadastro);
		return "editar-movimento-fundo";
	}
	
	@RequestMapping("{movimento.fundo.id}/movimento/{movimento.id}")
	public ModelAndView editar(@PathVariable("movimento.fundo.id") int idFundo, @PathVariable("movimento.id") int idMovimento){
		MovimentoFundo movimentoFundo;
		mav = new ModelAndView();
		
		movimentoFundo = movimentoFundoService.buscarMovimentoPorIdFundoEIdMov(idFundo, idMovimento);
		
		
		mav.setViewName("editar-movimento-fundo");
		mav.addObject("movimentoFundo", movimentoFundo);
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
	
	@RequestMapping("tipo-movimento")
	public ModelAndView listarTipoDeMovimentos(){
		mav = new ModelAndView();
		mav.addObject("tipos", tipoDeMovimentoFundoService.listarTodos());
		mav.setViewName("listar-tipo-de-movimento");
		
		return mav;
	}
}
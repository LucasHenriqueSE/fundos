package br.com.fornax.fundos.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.fornax.fundos.model.Cota;
import br.com.fornax.fundos.model.Fundo;
import br.com.fornax.fundos.model.MovimentoFundo;
import br.com.fornax.fundos.model.TipoDeFundo;
import br.com.fornax.fundos.services.CotaService;
import br.com.fornax.fundos.services.FundoService;
import br.com.fornax.fundos.services.MovimentoFundoService;
import br.com.fornax.fundos.services.TipoDeFundoService;

@Controller
public class FundoController {
	
	@Inject
	private MovimentoFundoService movimentoFundoService;

	@Inject
	private FundoService fundoService;

	@Inject
	private TipoDeFundoService tipoDeFundoService;

	@Inject
	private CotaService cotaService;

	private ModelAndView mav;

	@RequestMapping("cadastrar")
	public ModelAndView cadastrarNovoFundo() {
		List<Object> listaTipoDeFundos;
		mav = new ModelAndView();

		listaTipoDeFundos = tipoDeFundoService.listarTodos();
		mav.setViewName("novo-fundo");
		mav.addObject("tipos", listaTipoDeFundos);
		return mav;
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

	@RequestMapping("fundo/{id}/cotas")
	public ModelAndView listarCotas(@PathVariable("id") int id) {
		List<Cota> listaCotas;
		mav = new ModelAndView();
		listaCotas = cotaService.listarCotasPorFundo(id);
		mav.setViewName("listar-cota");
		mav.addObject("cotas", listaCotas);
		return mav;
	}
	
	@RequestMapping("fundo/{id}/movimentos")
	public ModelAndView listarMovimentos(@PathVariable("id") int id) {
		List<MovimentoFundo> listaMovimentos;
		mav = new ModelAndView();
		listaMovimentos = movimentoFundoService.listarMovimentosPorFundo(id);
		mav.setViewName("listar-movimento");
		mav.addObject("movimentos", listaMovimentos);
		
		return mav;
	}
	
	@RequestMapping("editar")
	public ModelAndView editar(){
		List<Object> listaFundos;
		mav = new ModelAndView();

		listaFundos = fundoService.listarTodos();
		mav.setViewName("editar-fundo");
		mav.addObject("fundos", listaFundos);

		return mav;
	}
}
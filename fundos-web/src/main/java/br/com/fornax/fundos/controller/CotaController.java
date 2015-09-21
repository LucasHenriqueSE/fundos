package br.com.fornax.fundos.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.fornax.fundos.model.Cota;
import br.com.fornax.fundos.services.CotaService;
import br.com.fornax.fundos.services.FundoService;

@Controller
@RequestMapping("cota")
public class CotaController {

	@Inject
	private CotaService cotaService;
	
	@Inject
	private FundoService fundoService;

	private ModelAndView mav;

	@RequestMapping("cadastrar")
	public ModelAndView cadastrarCota() {
		List<Object> listaFundos;
		mav = new ModelAndView();

		listaFundos = fundoService.listarTodos();
		mav.setViewName("nova-cota");
		mav.addObject("fundos", listaFundos);

		return mav;
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvarCota(Cota nova) {
		cotaService.inserir(nova);

		return "nova-cota";
	}
	
	@RequestMapping("editar/{idCota}")
	public ModelAndView editarCota(@PathVariable("idCota") int idCota){
		mav = new ModelAndView();
		Cota cota = cotaService.buscarCotaPorId(idCota);

		mav.setViewName("editar-cota");
		mav.addObject("cota", cota);

		return mav;
	}
	
	@RequestMapping("alterar")
	public String alterarCota(Cota cota, String dataCadastro){
		cotaService.editar(cota, dataCadastro);
		return "editar-cota";
	}
}
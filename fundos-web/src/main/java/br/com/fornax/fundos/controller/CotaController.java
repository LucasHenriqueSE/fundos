package br.com.fornax.fundos.controller;

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

	@RequestMapping("cadastrar/{idFundo}")
	public ModelAndView cadastrarCota(@PathVariable("idFundo") int idFundo) {
		mav = new ModelAndView();

		mav.setViewName("nova-cota");
		mav.addObject("fundos", fundoService.listarTodos());
		mav.addObject("idFundo", idFundo);
		return mav;
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvarCota(Cota cota) {
		cotaService.inserir(cota);

		return "redirect:/fundo/" + cota.getFundo().getId() + "/cotas";
	}

	@RequestMapping("{idCota}/editar")
	public ModelAndView editarCota(@PathVariable("idCota") int idCota) {
		mav = new ModelAndView();
		Cota cota = cotaService.buscarCotaPorId(idCota);

		mav.setViewName("editar-cota");
		mav.addObject("cota", cota);

		return mav;
	}

	@RequestMapping("alterar")
	public String alterarCota(Cota cota, String dataCadastro) {
		cotaService.editar(cota, dataCadastro);

		return "redirect:/fundo/" + cota.getFundo().getId() + "/cotas";
	}

	@RequestMapping("{id}/deletar")
	public String deletarCota(@PathVariable("id") int idCota) {
		Cota cota = cotaService.buscarCotaPorId(idCota);
		cotaService.excluir(cota);

		return "redirect:/fundo/" + cota.getFundo().getId() + "/cotas";
	}
}
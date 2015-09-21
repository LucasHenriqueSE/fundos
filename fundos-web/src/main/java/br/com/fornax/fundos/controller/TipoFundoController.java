package br.com.fornax.fundos.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.fornax.fundos.model.TipoDeFundo;
import br.com.fornax.fundos.services.TipoDeFundoService;

@Controller
public class TipoFundoController {
	
	@Inject
	private TipoDeFundoService tipoDeFundoService;
	
	private ModelAndView mav = new ModelAndView();
	
	/**Redireciona para a p�gina que lista os tipos de fundo cadastrados no sistema
	 * @return
	 */
	@RequestMapping("tipo-de-fundo")
	public ModelAndView tiposDeFundo() {
		this.mav.clear();
		this.mav.setViewName("listar-tipo-fundo");
		this.mav.addObject("tipos",tipoDeFundoService.listarTodos());
		return mav;
	}
	
	/**Redireciona para a p�gina de cadastro de tipos de fundo
	 * @return
	 */
	@RequestMapping("tipo-de-fundo/cadastrar")
	public String cadastrarTipoDeFundo() {
		return "novo-tipo-fundo";
	}
	
	/**Salva o tipo de fundo no banco de dados.
	 * @param novo
	 * @return
	 */
	@RequestMapping(value = "tipo-de-fundo/salvar", method = RequestMethod.POST)
	public String salvarTipoDeFundo(TipoDeFundo novo) {
		tipoDeFundoService.inserir(novo);
		return "redirect:/tipo-de-fundo";
	}

}
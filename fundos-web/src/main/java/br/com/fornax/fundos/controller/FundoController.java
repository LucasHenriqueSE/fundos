package br.com.fornax.fundos.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.fornax.fundos.model.Fundo;
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

	private ModelAndView mav = new ModelAndView();
	
	/**Redireciona para a p�gina listar-fundo listando os fundos cadastrados no sistema.
	 * @return
	 */
	@RequestMapping("/")
	public ModelAndView index(HttpServletRequest request){
		this.mav.clear();
		this.mav.setViewName("listar-fundo");
		this.mav.addObject("fundos", fundoService.listarTodos());
		this.mav.addObject("excluiu", request.getSession().getAttribute("excluiu"));
		request.getSession().invalidate();
		return mav;
	}

	/**Redireciona para a p�gina de cadastro de Fundo.
	 * @return
	 */
	@RequestMapping("cadastrar")
	public ModelAndView cadastrarNovoFundo() {
		this.mav.clear();
		mav.setViewName("novo-fundo");
		mav.addObject("tipos", tipoDeFundoService.listarTodos());
		return mav;
	}
	
	/**Redireciona para a p�gina de editar fundo de acordo com o id passado
	 * no par�metro.
	 * @param id
	 * @return
	 */
	@RequestMapping("fundo/{id}/editar")
	public ModelAndView editar(@PathVariable("id") int id){
		this.mav.clear();
		mav.setViewName("editar-fundo");
		mav.addObject("fundo", fundoService.listarPorId(id));
		mav.addObject("tipos", tipoDeFundoService.listarTodos());
		return mav;
	}
	
	/**Redireciona para p�gina que lista todas as cotas relacionadas ao fundo passado
	 * no par�metro.
	 * @param id
	 * @return
	 */
	@RequestMapping("fundo/{idFundo}/cotas")
	public ModelAndView listarCotas(@PathVariable("idFundo") int idFundo) {
		this.mav.clear();
		mav.setViewName("listar-cota");
		mav.addObject("cotas", cotaService.listarCotasPorFundo(idFundo));
		return mav;
	}
	
	/**Redireciona para a p�gina que lista todos os movimentos relacionados ao fundo passado
	 * no par�metro.
	 * @param id
	 * @return
	 */
	@RequestMapping("fundo/{idFundo}/movimentos")
	public ModelAndView listarMovimentos(@PathVariable("idFundo") int idFundo) {
		this.mav.clear();
		mav.setViewName("listar-movimento");
		mav.addObject("movimentos", movimentoFundoService.listarMovimentosPorFundo(idFundo));
		mav.addObject("idFundo", idFundo);
		return mav;
	}

	/**Salva o fundo no banco de dados e redireciona para a p�gina de lista de fundos
	 * @param novo
	 * @return
	 */
	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvarNovoFundo(Fundo novo) {
		fundoService.inserir(novo);
		return "redirect:/";
	}
	
	/**Altera o fundo no banco de dados.
	 * @param fundo
	 * @return
	 */
	@RequestMapping(value="alterar", method=RequestMethod.POST)
	public String alterar(Fundo fundo){
		fundoService.editar(fundo);
		return "redirect:/";
	}
	
	/**Exclui o fundo do banco de dados de acordo com o id 
	 * passado no par�metro.
	 * @param id
	 * @return
	 */
	@RequestMapping("fundo/{idFundo}/excluir")
	public String excluir(@PathVariable("idFundo") int id, HttpServletRequest request){
		Fundo fundo = fundoService.listarPorId(id);
		Boolean excluiu= fundoService.excluir(fundo);
		request.getSession().setAttribute("excluiu", excluiu);
		return "redirect:/";
	}
}
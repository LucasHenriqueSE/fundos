package br.com.fornax.fundos.controller;

import javax.inject.Inject;

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
	
	
	/**Redireciona para a página index listando os fundos cadastrados no sistema.
	 * @return
	 */
	@RequestMapping("/")
	public ModelAndView index(){
		this.mav.clear();
		this.mav.setViewName("index");
		this.mav.addObject("fundos", fundoService.listarTodos());
		
		return mav;
	}

	/**Redireciona para a página de cadastro de Fundo.
	 * @return
	 */
	@RequestMapping("cadastrar")
	public ModelAndView cadastrarNovoFundo() {
		this.mav.clear();
		mav.setViewName("novo-fundo");
		mav.addObject("tipos", tipoDeFundoService.listarTodos());
		return mav;
	}
	
	/**Redireciona para a página de editar fundo de acordo com o id passado
	 * no parâmetro.
	 * @param id
	 * @return
	 */
	@RequestMapping("fundo/{id}/editar")
	public ModelAndView editar(@PathVariable("id") int id){
		this.mav.clear();
		mav.setViewName("editar-fundo");
		mav.addObject("fundo", fundoService.listarPorId(id));
		return mav;
	}
	
	/**Redireciona para página que lista todas as cotas relacionadas ao fundo passado
	 * no parâmetro.
	 * @param id
	 * @return
	 */
	@RequestMapping("fundo/{id}/cotas")
	public ModelAndView listarCotas(@PathVariable("id") int id) {
		this.mav.clear();
		mav.setViewName("listar-cota");
		mav.addObject("cotas", cotaService.listarCotasPorFundo(id));
		return mav;
	}
	
	/**Redireciona para a página que lista todos os movimentos relacionados ao fundo passado
	 * no parâmetro.
	 * @param id
	 * @return
	 */
	@RequestMapping("fundo/{id}/movimentos")
	public ModelAndView listarMovimentos(@PathVariable("id") int id) {
		this.mav.clear();
		mav.setViewName("listar-movimento");
		mav.addObject("movimentos", movimentoFundoService.listarMovimentosPorFundo(id));
		return mav;
	}
	
	/**Salva o fundo no banco de dados e redireciona para a página de lista de fundos
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
	@RequestMapping(value="fundos/alterar", method=RequestMethod.POST)
	public String alterar(Fundo fundo){
		fundoService.editar(fundo);
		return "redirect:/";
	}
	
	/**Exclui o fundo do banco de dados de acordo com o id 
	 * passado no parâmetro.
	 * @param id
	 * @return
	 */
	@RequestMapping("fundo/{id}/excluir")
	public String excluir(@PathVariable("id") int id){
		Fundo fundo = fundoService.listarPorId(id);
		fundoService.excluir(fundo);
		return "redirect:/";
	}
}
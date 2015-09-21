package br.com.fornax.fundos.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_FUNDO")
public class TipoDeFundo {

	@Id
	@GeneratedValue
	@Column(name = "ID_TIPO_FUNDO")
	private Integer id;

	@Column(name = "NOME_TIPO_FUNDO")
	private String nomeTipoFundo;

	@OneToMany(mappedBy = "tipoFundo", fetch = FetchType.LAZY)
	private List<Fundo> listaFundos;
	
	/**GETTERS AND SETTERS*/

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeTipoFundo() {
		return nomeTipoFundo;
	}

	public void setNomeTipoFundo(String nomeTipoFundo) {
		this.nomeTipoFundo = nomeTipoFundo;
	}

	public List<Fundo> getListaFundos() {
		return listaFundos;
	}

	public void setListaFundos(List<Fundo> listaFundos) {
		this.listaFundos = listaFundos;
	}
}
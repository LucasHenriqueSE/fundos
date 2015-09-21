package br.com.fornax.fundos.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FUNDO")
public class Fundo {

	@Id
	@GeneratedValue
	@Column(name = "ID_FUNDO")
	private Integer id;

	@Column(name = "NOME")
	private String nome;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "ID_TIPO_FUNDO", nullable = false)
	private TipoDeFundo tipoFundo;

	@OneToMany(mappedBy = "fundo", fetch = FetchType.LAZY)
	private List<Cota> listaCotas;

	@OneToMany(mappedBy = "fundo", fetch = FetchType.LAZY)
	private List<MovimentoFundo> listaMovimentos;
	
	/**GETTERS AND SETTERS*/

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoDeFundo getTipoFundo() {
		return tipoFundo;
	}

	public void setTipoFundo(TipoDeFundo tipoFundo) {
		this.tipoFundo = tipoFundo;
	}

	public List<Cota> getListaCotas() {
		return listaCotas;
	}

	public void setListaCotas(List<Cota> listaCotas) {
		this.listaCotas = listaCotas;
	}

	public List<MovimentoFundo> getListaMovimentos() {
		return listaMovimentos;
	}

	public void setListaMovimentos(List<MovimentoFundo> listaMovimentos) {
		this.listaMovimentos = listaMovimentos;
	}
}
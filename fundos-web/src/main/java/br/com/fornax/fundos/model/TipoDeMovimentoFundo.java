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
@Table(name = "TIPO_MOVIMENTO_FUNDO")
public class TipoDeMovimentoFundo {

	@Id
	@GeneratedValue
	@Column(name = "ID_TIPO_MOVIMENTO_FUNDO")
	private Integer id;

	@Column(name = "NOME_TIPO_MOVIMENTO_FUNDO")
	private String nomeTipoMovimentoFundo;

	@OneToMany(mappedBy = "tipoMovimento", fetch = FetchType.LAZY)
	private List<MovimentoFundo> listaMovimentos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeTipoMovimentoFundo() {
		return nomeTipoMovimentoFundo;
	}

	public void setNomeTipoMovimentoFundo(String nomeTipoMovimentoFundo) {
		this.nomeTipoMovimentoFundo = nomeTipoMovimentoFundo;
	}

	public List<MovimentoFundo> getListaMovimentos() {
		return listaMovimentos;
	}

	public void setListaMovimentos(List<MovimentoFundo> listaMovimentos) {
		this.listaMovimentos = listaMovimentos;
	}
}
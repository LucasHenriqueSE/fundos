package br.com.fornax.fundos.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "MOVIMENTO_FUNDO")
public class MovimentoFundo {

	@Id
	@GeneratedValue
	@Column(name = "ID_MOVIMENTO_FUNDO")
	private Integer id;

	@Column(name = "VALOR_MOVIMENTO_FUNDO")
	private Float valorMovimentoFundo;

	@Column(name = "QTD_MOVIMENTO_FUNDO")
	private Float qtdMovimentoFundo;

	@Column(name = "VALOR_COTA_MOVIMENTO_FUNDO")
	private Float valorCotaMovimentoFundo;

	@Column(name = "DATA_MOVIMENTO_FUNDO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataMovimentoFundo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_FUNDO", nullable = false)
	private Fundo fundo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_TIPO_MOVIMENTO_FUNDO", nullable = false)
	private TipoDeMovimentoFundo tipoMovimento;
	
	/**GETTERS AND SETTERS*/

	public Integer getId() {
		return id;
	}
	
	public Float getValorMovimentoFundo() {
		return valorMovimentoFundo;
	}

	public void setValorMovimentoFundo(Float valorMovimentoFundo) {
		this.valorMovimentoFundo = valorMovimentoFundo;
	}

	public Float getQtdMovimentoFundo() {
		return qtdMovimentoFundo;
	}

	public void setQtdMovimentoFundo(Float qtdMovimentoFundo) {
		this.qtdMovimentoFundo = qtdMovimentoFundo;
	}

	public Float getValorCotaMovimentoFundo() {
		return valorCotaMovimentoFundo;
	}

	public void setValorCotaMovimentoFundo(Float valorCotaMovimentoFundo) {
		this.valorCotaMovimentoFundo = valorCotaMovimentoFundo;
	}

	public Date getDataMovimentoFundo() {
		return dataMovimentoFundo;
	}

	public void setDataMovimentoFundo(Date dataMovimentoFundo) {
		this.dataMovimentoFundo = dataMovimentoFundo;
	}

	public Fundo getFundo() {
		return fundo;
	}

	public void setFundo(Fundo fundo) {
		this.fundo = fundo;
	}

	public TipoDeMovimentoFundo getTipoMovimento() {
		return tipoMovimento;
	}

	public void setTipoMovimento(TipoDeMovimentoFundo tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}
}
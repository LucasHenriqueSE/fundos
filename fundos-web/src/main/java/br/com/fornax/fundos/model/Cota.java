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
@Table(name = "COTA")
public class Cota {

	@Id
	@GeneratedValue
	@Column(name = "ID_COTA")
	private Integer id;

	@Column(name = "VALOR")
	private Float valor;

	@Column(name = "DATA_VALOR")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_FUNDO", nullable = false)
	private Fundo fundo;
	
	/**GETTERS AND SETTERS*/

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Fundo getFundo() {
		return fundo;
	}

	public void setFundo(Fundo fundo) {
		this.fundo = fundo;
	}
}
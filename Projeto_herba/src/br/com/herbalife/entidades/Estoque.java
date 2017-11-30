package br.com.herbalife.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estoque database table.
 * 
 */
@Entity
@NamedQuery(name="Estoque.findAll", query="SELECT e FROM Estoque e")
public class Estoque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idestoque;

	private Integer qtd;

	private Integer qtdatual;

	private Integer qtdcomprada;

	private Integer qtdmaxima;

	private Integer qtdminima;

	//bi-directional many-to-one association to Produto
	@ManyToOne
	@JoinColumn(name="idproduto")
	private Produto produto;

	//bi-directional one-to-one association to RelacaoItemestoque
	@OneToOne(mappedBy="estoque")
	private RelacaoItemestoque relacaoItemestoque;

	public Estoque() {
	}

	public Integer getIdestoque() {
		return this.idestoque;
	}

	public void setIdestoque(Integer idestoque) {
		this.idestoque = idestoque;
	}

	public Integer getQtd() {
		return this.qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public Integer getQtdatual() {
		return this.qtdatual;
	}

	public void setQtdatual(Integer qtdatual) {
		this.qtdatual = qtdatual;
	}

	public Integer getQtdcomprada() {
		return this.qtdcomprada;
	}

	public void setQtdcomprada(Integer qtdcomprada) {
		this.qtdcomprada = qtdcomprada;
	}

	public Integer getQtdmaxima() {
		return this.qtdmaxima;
	}

	public void setQtdmaxima(Integer qtdmaxima) {
		this.qtdmaxima = qtdmaxima;
	}

	public Integer getQtdminima() {
		return this.qtdminima;
	}

	public void setQtdminima(Integer qtdminima) {
		this.qtdminima = qtdminima;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public RelacaoItemestoque getRelacaoItemestoque() {
		return this.relacaoItemestoque;
	}

	public void setRelacaoItemestoque(RelacaoItemestoque relacaoItemestoque) {
		this.relacaoItemestoque = relacaoItemestoque;
	}

}
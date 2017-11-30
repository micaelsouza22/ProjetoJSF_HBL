package br.com.herbalife.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the relacao_itemestoque database table.
 * 
 */
@Entity
@Table(name="relacao_itemestoque")
@NamedQuery(name="RelacaoItemestoque.findAll", query="SELECT r FROM RelacaoItemestoque r")
public class RelacaoItemestoque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idestoque;

	@Temporal(TemporalType.DATE)
	private Date dtcompra;

	private Integer qtd;

	private double valortotal;

	private double valortotalcompra;

	private double valorunitario;

	//bi-directional one-to-one association to Estoque
	@OneToOne
	@JoinColumn(name="idestoque")
	private Estoque estoque;

	//bi-directional many-to-one association to Produto
	@ManyToOne
	@JoinColumn(name="idproduto")
	private Produto produto;

	public RelacaoItemestoque() {
	}

	public Integer getIdestoque() {
		return this.idestoque;
	}

	public void setIdestoque(Integer idestoque) {
		this.idestoque = idestoque;
	}

	public Date getDtcompra() {
		return this.dtcompra;
	}

	public void setDtcompra(Date dtcompra) {
		this.dtcompra = dtcompra;
	}

	public Integer getQtd() {
		return this.qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public double getValortotal() {
		return this.valortotal;
	}

	public void setValortotal(double valortotal) {
		this.valortotal = valortotal;
	}

	public double getValortotalcompra() {
		return this.valortotalcompra;
	}

	public void setValortotalcompra(double valortotalcompra) {
		this.valortotalcompra = valortotalcompra;
	}

	public double getValorunitario() {
		return this.valorunitario;
	}

	public void setValorunitario(double valorunitario) {
		this.valorunitario = valorunitario;
	}

	public Estoque getEstoque() {
		return this.estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
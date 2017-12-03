package br.com.herbalife.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the itempedido database table.
 * 
 */
@Entity
@NamedQuery(name="Itempedido.findAll", query="SELECT i FROM Itempedido i")
public class Itempedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer iditem;

	private Integer qtditem;

	private String valortotal;

	//bi-directional many-to-one association to Pedido
	@ManyToOne
	@JoinColumn(name="numeropedido")
	private Pedido pedido;

	//bi-directional many-to-one association to Produto
	@ManyToOne
	@JoinColumn(name="idproduto")
	private Produto produto;

	public Itempedido() {
	}

	public Integer getIditem() {
		return this.iditem;
	}

	public void setIditem(Integer iditem) {
		this.iditem = iditem;
	}

	public Integer getQtditem() {
		return this.qtditem;
	}

	public void setQtditem(Integer qtditem) {
		this.qtditem = qtditem;
	}

	public String getValortotal() {
		return this.valortotal;
	}

	public void setValortotal(String valortotal) {
		this.valortotal = valortotal;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
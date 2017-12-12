package br.com.herbalife.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;


/**
 * The persistent class for the itempedido database table.
 * 
 */
@Entity
@Table(name = "itempedido")
@NamedQuery(name="Itempedido.findAll", query="SELECT i FROM Itempedido i")
public class Itempedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "iditem")
	private Integer iditem;
	
	@Column(name = "qtditem", nullable = false)
	private Integer qtditem;
	
	@Column(name = "valortotal", precision = 6, scale = 2, nullable = false)
	private BigDecimal valortotal;

	//bi-directional many-to-one association to Pedido
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="numeropedido", referencedColumnName = "numeropedido", nullable = false)
	private Pedido pedido;

	//bi-directional many-to-one association to Produto
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idproduto", referencedColumnName = "idproduto", nullable = false)
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

	public BigDecimal getValortotal() {
		return valortotal;
	}

	public void setValortotal(BigDecimal valortotal) {
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
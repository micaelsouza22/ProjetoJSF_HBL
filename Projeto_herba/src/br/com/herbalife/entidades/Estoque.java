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

	//bi-directional many-to-one association to Produto
	@ManyToOne
	@JoinColumn(name="idproduto")
	private Produto produto;

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

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
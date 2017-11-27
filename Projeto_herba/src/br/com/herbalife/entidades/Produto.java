package br.com.herbalife.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the produto database table.
 * 
 */
@Entity
@NamedQuery(name="Produto.findAll", query="SELECT p FROM Produto p")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idproduto;

	private Integer codbarras;

	private String nomeproduto;

	private Integer qtdestoque;

	private double valorunitario;

	//bi-directional many-to-one association to Estoque
	@OneToMany(mappedBy="produto")
	private List<Estoque> estoques;

	//bi-directional many-to-one association to Itempedido
	@OneToMany(mappedBy="produto")
	private List<Itempedido> itempedidos;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="idcategoria")
	private Categoria categoria;

	public Produto() {
	}

	public Integer getIdproduto() {
		return this.idproduto;
	}

	public void setIdproduto(Integer idproduto) {
		this.idproduto = idproduto;
	}

	public Integer getCodbarras() {
		return this.codbarras;
	}

	public void setCodbarras(Integer codbarras) {
		this.codbarras = codbarras;
	}

	public String getNomeproduto() {
		return this.nomeproduto;
	}

	public void setNomeproduto(String nomeproduto) {
		this.nomeproduto = nomeproduto;
	}

	public Integer getQtdestoque() {
		return this.qtdestoque;
	}

	public void setQtdestoque(Integer qtdestoque) {
		this.qtdestoque = qtdestoque;
	}

	public double getValorunitario() {
		return this.valorunitario;
	}

	public void setValorunitario(double valorunitario) {
		this.valorunitario = valorunitario;
	}

	public List<Estoque> getEstoques() {
		return this.estoques;
	}

	public void setEstoques(List<Estoque> estoques) {
		this.estoques = estoques;
	}

	public Estoque addEstoque(Estoque estoque) {
		getEstoques().add(estoque);
		estoque.setProduto(this);

		return estoque;
	}

	public Estoque removeEstoque(Estoque estoque) {
		getEstoques().remove(estoque);
		estoque.setProduto(null);

		return estoque;
	}

	public List<Itempedido> getItempedidos() {
		return this.itempedidos;
	}

	public void setItempedidos(List<Itempedido> itempedidos) {
		this.itempedidos = itempedidos;
	}

	public Itempedido addItempedido(Itempedido itempedido) {
		getItempedidos().add(itempedido);
		itempedido.setProduto(this);

		return itempedido;
	}

	public Itempedido removeItempedido(Itempedido itempedido) {
		getItempedidos().remove(itempedido);
		itempedido.setProduto(null);

		return itempedido;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
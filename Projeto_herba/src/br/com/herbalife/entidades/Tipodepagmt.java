package br.com.herbalife.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipodepagmt database table.
 * 
 */
@Entity
@NamedQuery(name="Tipodepagmt.findAll", query="SELECT t FROM Tipodepagmt t")
public class Tipodepagmt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idtipopag;

	private String descricao;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="tipodepagmt")
	private List<Pedido> pedidos;

	public Tipodepagmt() {
	}

	public Integer getIdtipopag() {
		return this.idtipopag;
	}

	public void setIdtipopag(Integer idtipopag) {
		this.idtipopag = idtipopag;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setTipodepagmt(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setTipodepagmt(null);

		return pedido;
	}

}
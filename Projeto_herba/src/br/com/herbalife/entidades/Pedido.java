package br.com.herbalife.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer numeropedido;

	@Temporal(TemporalType.DATE)
	private Date datapedido;

	private Time horapedido;

	private double valortotalpedido;

	//bi-directional many-to-one association to Itempedido
	@OneToMany(mappedBy="pedido")
	private List<Itempedido> itempedidos;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="idcliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Tipodepagmt
	@ManyToOne
	@JoinColumn(name="idtipopag")
	private Tipodepagmt tipodepagmt;

	public Pedido() {
	}

	public Integer getNumeropedido() {
		return this.numeropedido;
	}

	public void setNumeropedido(Integer numeropedido) {
		this.numeropedido = numeropedido;
	}

	public Date getDatapedido() {
		return this.datapedido;
	}

	public void setDatapedido(Date datapedido) {
		this.datapedido = datapedido;
	}

	public Time getHorapedido() {
		return this.horapedido;
	}

	public void setHorapedido(Time horapedido) {
		this.horapedido = horapedido;
	}

	public double getValortotalpedido() {
		return this.valortotalpedido;
	}

	public void setValortotalpedido(double valortotalpedido) {
		this.valortotalpedido = valortotalpedido;
	}

	public List<Itempedido> getItempedidos() {
		return this.itempedidos;
	}

	public void setItempedidos(List<Itempedido> itempedidos) {
		this.itempedidos = itempedidos;
	}

	public Itempedido addItempedido(Itempedido itempedido) {
		getItempedidos().add(itempedido);
		itempedido.setPedido(this);

		return itempedido;
	}

	public Itempedido removeItempedido(Itempedido itempedido) {
		getItempedidos().remove(itempedido);
		itempedido.setPedido(null);

		return itempedido;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Tipodepagmt getTipodepagmt() {
		return this.tipodepagmt;
	}

	public void setTipodepagmt(Tipodepagmt tipodepagmt) {
		this.tipodepagmt = tipodepagmt;
	}

}
package br.com.herbalife.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@Table(name = "pedido")
@NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "numeropedido")
	private Integer numeropedido;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "horapedido", nullable = false)
	private Date horapedido;

	@Column(name = "valortotalpedido", precision = 6, scale = 2, nullable = false)
	private BigDecimal valortotalpedido;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idusuario", referencedColumnName = "idusuario", nullable = false)
	private Usuario usuario;

	// bi-directional many-to-one association to Itempedido
	@OneToMany(mappedBy = "pedido")
	private List<Itempedido> itempedidos;

	// bi-directional many-to-one association to Cliente
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idcliente")
	private Cliente cliente;

	// bi-directional many-to-one association to Tipodepagmt
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idtipopag")
	private Tipodepagmt tipodepagmt;

	public Date getHorapedido() {
		return horapedido;
	}

	public void setHorapedido(Date horapedido) {
		this.horapedido = horapedido;
	}

	public BigDecimal getValortotalpedido() {
		return valortotalpedido;
	}

	public void setValortotalpedido(BigDecimal valortotalpedido) {
		this.valortotalpedido = valortotalpedido;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Pedido() {
	}

	public Integer getNumeropedido() {
		return this.numeropedido;
	}

	public void setNumeropedido(Integer numeropedido) {
		this.numeropedido = numeropedido;
	}

	public void setHorapedido(Time horapedido) {
		this.horapedido = horapedido;
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
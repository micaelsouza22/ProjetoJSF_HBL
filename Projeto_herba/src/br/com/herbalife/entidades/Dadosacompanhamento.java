package br.com.herbalife.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the dadosacompanhamento database table.
 * 
 */
@Entity
@NamedQuery(name="Dadosacompanhamento.findAll", query="SELECT d FROM Dadosacompanhamento d")
public class Dadosacompanhamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idmedida;

	private double cintura;

	@Temporal(TemporalType.DATE)
	private Date dataacomp;

	private double gordura;

	private double gorduravisc;

	private Integer idadebiologica;

	private double imc;

	private double metbasal;

	private double musculo;

	private double peso;

	private double quadril;

	private double torax;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="idcliente")
	private Cliente cliente;

	public Dadosacompanhamento() {
	}

	public Integer getIdmedida() {
		return this.idmedida;
	}

	public void setIdmedida(Integer idmedida) {
		this.idmedida = idmedida;
	}

	public double getCintura() {
		return this.cintura;
	}

	public void setCintura(double cintura) {
		this.cintura = cintura;
	}

	public Date getDataacomp() {
		return this.dataacomp;
	}

	public void setDataacomp(Date dataacomp) {
		this.dataacomp = dataacomp;
	}

	public double getGordura() {
		return this.gordura;
	}

	public void setGordura(double gordura) {
		this.gordura = gordura;
	}

	public double getGorduravisc() {
		return this.gorduravisc;
	}

	public void setGorduravisc(double gorduravisc) {
		this.gorduravisc = gorduravisc;
	}

	public Integer getIdadebiologica() {
		return this.idadebiologica;
	}

	public void setIdadebiologica(Integer idadebiologica) {
		this.idadebiologica = idadebiologica;
	}

	public double getImc() {
		return this.imc;
	}

	public void setImc(double imc) {
		this.imc = imc;
	}

	public double getMetbasal() {
		return this.metbasal;
	}

	public void setMetbasal(double metbasal) {
		this.metbasal = metbasal;
	}

	public double getMusculo() {
		return this.musculo;
	}

	public void setMusculo(double musculo) {
		this.musculo = musculo;
	}

	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getQuadril() {
		return this.quadril;
	}

	public void setQuadril(double quadril) {
		this.quadril = quadril;
	}

	public double getTorax() {
		return this.torax;
	}

	public void setTorax(double torax) {
		this.torax = torax;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
package br.com.herbalife.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the endereco database table.
 * 
 */
@Entity
@NamedQuery(name="Endereco.findAll", query="SELECT e FROM Endereco e")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idend;

	private String bairro;

	private String cidade;

	private String complemento;

	private String estado;

	@Column(name="numero_casa")
	private Integer numeroCasa;

	private String rua;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="endereco1")
	private List<Cliente> clientes1;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="endereco2")
	private List<Cliente> clientes2;

	public Endereco() {
	}

	public Integer getIdend() {
		return this.idend;
	}

	public void setIdend(Integer idend) {
		this.idend = idend;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getNumeroCasa() {
		return this.numeroCasa;
	}

	public void setNumeroCasa(Integer numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	public String getRua() {
		return this.rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public List<Cliente> getClientes1() {
		return this.clientes1;
	}

	public void setClientes1(List<Cliente> clientes1) {
		this.clientes1 = clientes1;
	}

	public Cliente addClientes1(Cliente clientes1) {
		getClientes1().add(clientes1);
		clientes1.setEndereco1(this);

		return clientes1;
	}

	public Cliente removeClientes1(Cliente clientes1) {
		getClientes1().remove(clientes1);
		clientes1.setEndereco1(null);

		return clientes1;
	}

	public List<Cliente> getClientes2() {
		return this.clientes2;
	}

	public void setClientes2(List<Cliente> clientes2) {
		this.clientes2 = clientes2;
	}

	public Cliente addClientes2(Cliente clientes2) {
		getClientes2().add(clientes2);
		clientes2.setEndereco2(this);

		return clientes2;
	}

	public Cliente removeClientes2(Cliente clientes2) {
		getClientes2().remove(clientes2);
		clientes2.setEndereco2(null);

		return clientes2;
	}

}
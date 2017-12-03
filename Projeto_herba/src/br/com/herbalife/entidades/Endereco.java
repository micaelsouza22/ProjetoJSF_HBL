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
	private Integer idendereco;

	private String bairro;

	private String cidade;

	private String complemento;

	@Column(name="numero_casa")
	private Integer numeroCasa;

	private String rua;

	private String uf;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="endereco")
	private List<Cliente> clientes;

	public Endereco() {
	}

	public Integer getIdendereco() {
		return this.idendereco;
	}

	public void setIdendereco(Integer idendereco) {
		this.idendereco = idendereco;
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

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente addCliente(Cliente cliente) {
		getClientes().add(cliente);
		cliente.setEndereco(this);

		return cliente;
	}

	public Cliente removeCliente(Cliente cliente) {
		getClientes().remove(cliente);
		cliente.setEndereco(null);

		return cliente;
	}

}
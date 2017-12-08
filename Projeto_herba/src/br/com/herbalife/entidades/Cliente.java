package br.com.herbalife.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idcliente;

	private String cidade;

	private String complemento;

	private String cpf;

	@Temporal(TemporalType.DATE)
	private Date dtnasc;

	private String endereco;

	private String nomecliente;

	private Integer numero;

	private String telefone;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="idestado")
	private Estado estado;

	//bi-directional many-to-one association to Dadosacompanhamento
	@OneToMany(mappedBy="cliente")
	private List<Dadosacompanhamento> dadosacompanhamentos;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="cliente")
	private List<Pedido> pedidos;

	public Cliente() {
	}

	public Integer getIdcliente() {
		return this.idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
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

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDtnasc() {
		return this.dtnasc;
	}

	public void setDtnasc(Date dtnasc) {
		this.dtnasc = dtnasc;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNomecliente() {
		return this.nomecliente;
	}

	public void setNomecliente(String nomecliente) {
		this.nomecliente = nomecliente;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Dadosacompanhamento> getDadosacompanhamentos() {
		return this.dadosacompanhamentos;
	}

	public void setDadosacompanhamentos(List<Dadosacompanhamento> dadosacompanhamentos) {
		this.dadosacompanhamentos = dadosacompanhamentos;
	}

	public Dadosacompanhamento addDadosacompanhamento(Dadosacompanhamento dadosacompanhamento) {
		getDadosacompanhamentos().add(dadosacompanhamento);
		dadosacompanhamento.setCliente(this);

		return dadosacompanhamento;
	}

	public Dadosacompanhamento removeDadosacompanhamento(Dadosacompanhamento dadosacompanhamento) {
		getDadosacompanhamentos().remove(dadosacompanhamento);
		dadosacompanhamento.setCliente(null);

		return dadosacompanhamento;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setCliente(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setCliente(null);

		return pedido;
	}

}
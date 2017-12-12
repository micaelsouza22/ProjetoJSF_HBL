package br.com.herbalife.entidades;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

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
	@Column(name="idcliente", unique=true, nullable=false)
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idcliente;
	@NotEmpty(message = "O campo de 'CIDADE' é obrigatуrio!")
	@Size(max = 100, message = "Tamanho inválido no campo 'CIDADE'. (máx. 100 caracteres)")
	private String cidade;
	@Size(max = 100, message = "Tamanho inválido no campo 'COMPLEMENTO'. (máx. 100 caracteres)")
	private String complemento;
	@Size(max = 11)
	@CPF(message = "O CPF informado é inválido!")
	private String cpf;
	
	@Temporal(TemporalType.DATE)
	private Date dtnasc;
	@Size(min = 4, max = 200, message = "Tamanho inválido no campo 'ENDEREÇO'. (4 - 200 caracteres)")
	@NotEmpty(message = "O campo de 'ENDEREÇO' é obrigatório!")
	private String endereco;
	@Size(min = 6, max = 70, message = "Tamanho inválido no campo 'NOME'. (6 - 70 caracteres)")
	@NotEmpty(message = "O campo de 'NOME' é obrigatório!")
	private String nomecliente;

	private Integer numero;
	@NotEmpty(message = "O campo de 'TELEFONE' é obrigatório!")
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
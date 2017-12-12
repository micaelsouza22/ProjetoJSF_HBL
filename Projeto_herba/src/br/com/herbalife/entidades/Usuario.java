package br.com.herbalife.entidades;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idusuario")
	private Integer idusuario;
	@CPF(message = "O CPF informado é inválido!")
	@Column(name = "cpf", length = 14, nullable = false, unique = true)
	private String cpf;
	@NotEmpty(message = "O campo 'NOME' é obrigatório!")
	@Size(min = 5, max = 100, message = "Tamanho inválido para o campo 'NOME'. (5 - 100)")
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;
	@NotEmpty(message = "O campo 'SENHA' é obrigatório!")
	@Size(min = 6, max = 8, message = "Tamanho inválido para o campo 'SENHA'. (6 - 8)")
	@Column(name = "senha", length = 32, nullable = false)
	private String senha;

	public Usuario() {
	}

	public Integer getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
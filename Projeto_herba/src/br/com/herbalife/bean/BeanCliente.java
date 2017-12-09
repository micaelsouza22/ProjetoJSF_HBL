package br.com.herbalife.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.herbalife.dao.ClienteDao;
import br.com.herbalife.dao.EstadoDao;
import br.com.herbalife.entidades.Cliente;
import br.com.herbalife.entidades.Estado;
import br.com.herbalife.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped

public class BeanCliente implements Serializable{
	
	private List<Cliente> listaCliente;
	private List<Estado> listaDeEstado;
	private ClienteDao daoCliente;
	private EstadoDao daoEstado;
	private Estado estados;
	private Cliente cliente;
	
	public BeanCliente() {
		daoCliente = new ClienteDao();
		daoEstado = new EstadoDao();
		estados = new Estado();
	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}


	public List<Estado> getListaDeEstado() {
		return listaDeEstado;
	}

	public Estado getEstados() {
		return estados;
	}

	public void setEstados(Estado estados) {
		this.estados = estados;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@PostConstruct
	public void carregaDadosTabelaCli() {
		
		try {
			
			listaCliente = daoCliente.listar("nomecliente");
			listaDeEstado = daoEstado.listar(null);
			
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	public void preparaNovoCliente() {
		try {
			
			cliente = new Cliente();
			listaDeEstado = daoEstado.listar(null);
			
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void salvarCliente() {
		try {
			
			daoCliente.salvar(cliente);
			listaCliente = daoCliente.listar("nomecliente");
			JSFUtil.mensagemSucesso("Cliente Salvo com Sucesso!");
			
		} catch (Exception e) {
			JSFUtil.mensagemSucesso("FATAL ERRO: " + e.getMessage());
		}
	}
	
	public void alterarCliente(ActionEvent evento) {
		
		try {
			
			cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionado");
			JSFUtil.mensagemSucesso("Cliente Editado com Sucesso!");
		} catch (Exception e) {
			JSFUtil.mensagemSucesso("FATAL ERRO: " + e.getMessage());
		}
		
	}
	
	public void removerCliente(ActionEvent evento) {
		try {
			
			cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionado");
			daoCliente.remover(cliente.getIdcliente());
			JSFUtil.mensagemSucesso("Cliente Removido com Sucesso!");
			listaCliente = daoCliente.listar("nomecliente");
			
		} catch (Exception e) {
			JSFUtil.mensagemSucesso("FATAL ERRO: " + e.getMessage());
		}
	}
	

}

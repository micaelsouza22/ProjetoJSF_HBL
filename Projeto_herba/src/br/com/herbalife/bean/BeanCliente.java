package br.com.herbalife.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.herbalife.dao.ClienteDao;
import br.com.herbalife.dao.EstadoDao;
import br.com.herbalife.entidades.Cliente;
import br.com.herbalife.entidades.Estado;

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
			
		} catch (Exception e) {
			e.getMessage();
		}
	}
	

}

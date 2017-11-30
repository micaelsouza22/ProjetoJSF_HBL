package br.com.herbalife.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.herbalife.dao.ClienteDao;
import br.com.herbalife.entidades.Cliente;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class BeanClientes implements Serializable{

	private List<Cliente> listaClientes;
	private ClienteDao daoClientes;
	private Cliente clientes;

	public BeanClientes() {
		daoClientes = new ClienteDao();
		clientes = new Cliente();
	}
	
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public Cliente getClientes() {
		return clientes;
	}

	public void setClientes(Cliente clientes) {
		this.clientes = clientes;
	}

	@PostConstruct
	public void carregaDadosTabela(){
		listaClientes = daoClientes.listar("idcliente");
	}
	
}

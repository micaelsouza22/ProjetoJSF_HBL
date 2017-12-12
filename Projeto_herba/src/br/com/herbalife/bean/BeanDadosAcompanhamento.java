package br.com.herbalife.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.herbalife.dao.ClienteDao;
import br.com.herbalife.dao.DadosAcompanhamentoDao;
import br.com.herbalife.entidades.Cliente;
import br.com.herbalife.entidades.Dadosacompanhamento;
import br.com.herbalife.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped

public class BeanDadosAcompanhamento implements Serializable{
	
	private List<Dadosacompanhamento> listaDadosAcomp;
	private List<Cliente> listaCliente;
	private ClienteDao daoCliente;
	private DadosAcompanhamentoDao daoDadosAcomp;
	private Dadosacompanhamento dadosAcomp;
	private Cliente cliente;
	
	public BeanDadosAcompanhamento() {
		daoCliente = new ClienteDao();
		daoDadosAcomp = new DadosAcompanhamentoDao();
		cliente = new Cliente();
	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	

	public Dadosacompanhamento getDadosAcomp() {
		return dadosAcomp;
	}

	public void setDadosAcomp(Dadosacompanhamento dadosAcomp) {
		this.dadosAcomp = dadosAcomp;
	}

	public List<Dadosacompanhamento> getListaDadosAcomp() {
		return listaDadosAcomp;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@PostConstruct
	public void carregaDadosTabelaAcomp() {
		
		try {
			
			listaDadosAcomp = daoDadosAcomp.listar("idCliente");
			listaCliente = daoCliente.listar(null);
			
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	public void preparaNovoAcompanhamento() {
		try {
			
			dadosAcomp = new Dadosacompanhamento();
			listaCliente = daoCliente.listar(null);
			
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void salvarAcompanhamento() {
		try {
			
			daoDadosAcomp.salvar(dadosAcomp);
			listaDadosAcomp = daoDadosAcomp.listar("idCliente");
			JSFUtil.mensagemSucesso("Acompanhamento Salvo com Sucesso!");
			
		} catch (Exception e) {
			JSFUtil.mensagemSucesso("FATAL ERRO: " + e.getMessage());
		}
	}
	
	public void alterarAcompanhamento(ActionEvent evento) {
		
		try {
			
			dadosAcomp = (Dadosacompanhamento) evento.getComponent().getAttributes().get("acompSelecionado");
			JSFUtil.mensagemSucesso("Acompanhamento Editado com Sucesso!");
		} catch (Exception e) {
			JSFUtil.mensagemSucesso("FATAL ERRO: " + e.getMessage());
		}
		
	}
	
	public void removerDadoAcompanhamento(ActionEvent evento) {
		try {
			
			dadosAcomp = (Dadosacompanhamento) evento.getComponent().getAttributes().get("acompSelecionado");
			daoDadosAcomp.remover(dadosAcomp.getIdmedida());
			JSFUtil.mensagemSucesso("Acompanhamento Removido com Sucesso!");
			listaDadosAcomp = daoDadosAcomp.listar("idCliente");
			
		} catch (Exception e) {
			JSFUtil.mensagemSucesso("FATAL ERRO: " + e.getMessage());
		}
	}
	

}

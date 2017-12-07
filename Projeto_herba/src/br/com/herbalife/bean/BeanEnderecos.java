package br.com.herbalife.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.herbalife.dao.EnderecoDao;
import br.com.herbalife.entidades.Endereco;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class BeanEnderecos implements Serializable{

	private List<Endereco> listaEnderecos;
	private EnderecoDao daoEnderecos;
	private Endereco enderecos;

	public BeanEnderecos() {
		daoEnderecos = new EnderecoDao();
		enderecos = new Endereco();
	}
	
	public List<Endereco> getListaEnderecos() {
		return listaEnderecos;
	}

	public Endereco getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Endereco enderecos) {
		this.enderecos = enderecos;
	}

	@PostConstruct
	public void carregaDadosTabela(){
		listaEnderecos = daoEnderecos.listar("idendereco");
	}
	
}

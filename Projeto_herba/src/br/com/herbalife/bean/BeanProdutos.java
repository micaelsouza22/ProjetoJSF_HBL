package br.com.herbalife.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.herbalife.dao.ProdutoDao;
import br.com.herbalife.entidades.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class BeanProdutos implements Serializable{

	private List<Produto> listaProdutos;
	private ProdutoDao daoProdutos;

	public BeanProdutos() {
		daoProdutos = new ProdutoDao();
	}
	
	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}
	@PostConstruct
	public void carregaDadosTabela(){
		listaProdutos = daoProdutos.listar("nomeproduto");
	}
	
}

package br.com.herbalife.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.herbalife.dao.CategoriaDao;
import br.com.herbalife.dao.EstoqueDao;
import br.com.herbalife.dao.ProdutoDao;
import br.com.herbalife.entidades.Categoria;
import br.com.herbalife.entidades.Estoque;
import br.com.herbalife.entidades.Produto;
	
@SuppressWarnings("serial")
@ManagedBean
@ViewScoped

public class BeanTesteEstoque implements Serializable {
	
	private List<Estoque> listaEstoque;
	private List<Produto> listaProduto;
	private List<Categoria> listaCategoria;
	private EstoqueDao daoEstoque;
	private ProdutoDao daoProduto;
	private CategoriaDao daoCategoria;
	private Estoque estoque;
	
	public BeanTesteEstoque() {
		daoEstoque = new EstoqueDao();
		daoProduto = new ProdutoDao();
		daoCategoria = new CategoriaDao();
		estoque = new Estoque();
	}
	
	
	
	
	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}




	public List<Estoque> getListaEstoque() {
		return listaEstoque;
	}
	public List<Produto> getListProduto() {
		return listaProduto;
	}
	public List<Categoria> getListaCategoria() {
		return listaCategoria;
	}
	
	@PostConstruct
	public void carregaDadosProduto() {
		
		try {
			
			listaEstoque = daoEstoque.listar("dtcompra");
			listaProduto = daoProduto.listar("nomeproduto");
			listaCategoria = daoCategoria.listar(null);
			
		} catch (Exception e) {
			e.getMessage();
		}
	
	}
	
	public void preparaRgEstoque() {
		try {
			
			estoque =  new Estoque();
			listaEstoque = daoEstoque.listar("dtcompra");

			
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void salvarRgEstoque() {
		try {
			
			daoEstoque.salvar(estoque);
			listaEstoque = daoEstoque.listar("dtcompra");
			
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	
}

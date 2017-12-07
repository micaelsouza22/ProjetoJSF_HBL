package br.com.herbalife.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.herbalife.dao.CategoriaDao;
import br.com.herbalife.dao.ProdutoDao;
import br.com.herbalife.entidades.Categoria;
import br.com.herbalife.entidades.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class BeanProdutos implements Serializable {

	private List<Produto> listaProdutos;
	private List<Categoria> listaCategorias;
	private ProdutoDao daoProdutos;
	private CategoriaDao daoCategoria;
	private Produto produtos;

	public BeanProdutos() {
		daoProdutos = new ProdutoDao();
		daoCategoria = new CategoriaDao();
		produtos = new Produto();
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public Produto getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto produtos) {
		this.produtos = produtos;
	}

	public List<Categoria> getListaCategorias() {
		return listaCategorias;
	}

	@PostConstruct
	public void carregaDadosTabela() {
		try {

			listaProdutos = daoProdutos.listar("nomeproduto");
			listaCategorias = daoCategoria.listar(null);

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void preparaNovoProduto() {
		try {
			
			produtos = new Produto();
			listaCategorias = daoCategoria.listar(null);
			
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void salvarProduto() {
		try {
			
			daoProdutos.salvar(produtos);
			listaProdutos = daoProdutos.listar("nomeproduto");
			
		} catch (Exception e) {
			e.getMessage();
		}
	}

}

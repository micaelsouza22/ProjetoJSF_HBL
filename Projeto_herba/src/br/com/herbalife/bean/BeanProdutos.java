package br.com.herbalife.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.herbalife.dao.CategoriaDao;
import br.com.herbalife.dao.EstoqueDao;
import br.com.herbalife.dao.ProdutoDao;
import br.com.herbalife.entidades.Categoria;
import br.com.herbalife.entidades.Estoque;
import br.com.herbalife.entidades.Produto;
import br.com.herbalife.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class BeanProdutos implements Serializable {

	private List<Produto> listaProdutos;
	private List<Categoria> listaCategorias;
	private List<Estoque> listaEstoque;
	private ProdutoDao daoProdutos;
	private CategoriaDao daoCategoria;
	private Produto produtos;
	
	private EstoqueDao daoestoque;
	

	public BeanProdutos() {
		daoProdutos = new ProdutoDao();
		daoCategoria = new CategoriaDao();
		produtos = new Produto();
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public Produto getProdutos() {
		if(produtos == null) {
			produtos = new Produto();
		}
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
			listaEstoque = daoestoque.listar(null);
			
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void salvarProduto() {
		try {
			
			daoProdutos.salvar(produtos);
			listaProdutos = daoProdutos.listar("nomeproduto");
			JSFUtil.mensagemSucesso("Produto salvo com sucesso!");
		} catch (Exception e) {
			JSFUtil.mensagemErro("ERRO: " + e.getMessage());
			JSFUtil.mensagemSucesso("Produto Salvo com Sucesso!");
			
		}
	}
	
	public void alterarProduto(ActionEvent evento) {
		produtos = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");
	}
	
	public void removerProduto(ActionEvent evento){
		try {
			produtos = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");
			daoProdutos.remover(produtos.getIdproduto());
			listaProdutos = daoProdutos.listar("nomeproduto");
			
			JSFUtil.mensagemSucesso("Produto Excluido com Sucesso!");
			
		} catch (Exception e) {
			JSFUtil.mensagemErro("FATAL ERRO: " + e.getMessage());
		}
	}

}

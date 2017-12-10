package br.com.herbalife.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.herbalife.util.JSFUtil;
import br.com.herbalife.dao.CategoriaDao;
import br.com.herbalife.entidades.Categoria;

@ManagedBean
@ViewScoped
public class CategoriaBean {
	
	private List<Categoria> listaCategorias;
	private CategoriaDao daoCategoria;
	private Categoria categoriaCadastro;
	
	public List<Categoria> getListaCategorias() {
		return listaCategorias;
	}

	public CategoriaBean() {
		daoCategoria = new CategoriaDao();
		categoriaCadastro = new Categoria();
	}
	
	public Categoria getCategoriaCadastro() {
		if(categoriaCadastro == null) {
			categoriaCadastro = new Categoria();
		}
		return categoriaCadastro;
	}
	
	public void setCategoriaCadastro(Categoria categoriaCadastro) {
		this.categoriaCadastro = categoriaCadastro;
	}
	@PostConstruct
	public void carregaDadosTabela(){
		listaCategorias = daoCategoria.listar("idcategoria");
	}
	
	public void salvarCategoria() {
		try {
			CategoriaDao daoCategoria = new CategoriaDao();
			daoCategoria.salvar(categoriaCadastro);
			JSFUtil.mensagemSucesso("Nova categoria salva com sucesso!");
		}catch(RuntimeException exception){
			JSFUtil.mensagemErro("Ocorreu um erro ao tentar cadastrar a categoria desejada: " + exception.getMessage());
		}
		
	}
}

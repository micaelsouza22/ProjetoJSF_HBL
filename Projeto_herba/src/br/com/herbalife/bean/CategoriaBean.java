package br.com.herbalife.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.herbalife.util.JSFUtil;
import br.com.herbalife.entidades.Categoria;

@ManagedBean
@ViewScoped
public class CategoriaBean {
	private Categoria categoriaCadastro;
	
	public Categoria getCategoriaCadastro() {
		if(categoriaCadastro == null) {
			categoriaCadastro = new Categoria();
		}
		return categoriaCadastro;
	}
	
	public void setCategoriaCadastro(Categoria categoriaCadastro) {
		this.categoriaCadastro = categoriaCadastro;
	}
	
	public void salvarCategoria() {
		JSFUtil.mensagemSucesso(categoriaCadastro.toString());
		JSFUtil.mensagemSucesso("Nova categoria salva com sucesso!");
	}
}

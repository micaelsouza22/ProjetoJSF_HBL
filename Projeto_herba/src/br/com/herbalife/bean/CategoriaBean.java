package br.com.herbalife.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.herbalife.util.JSFUtil;

@ManagedBean
@ViewScoped
public class CategoriaBean {
	public void salvarCategoria() {
		JSFUtil.mensagemSucesso("Nova categoria salva com sucesso!");
	}
}

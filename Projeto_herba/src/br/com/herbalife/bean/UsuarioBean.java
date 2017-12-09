package br.com.herbalife.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.herbalife.dao.UsuarioDao;
import br.com.herbalife.entidades.Usuario;
import br.com.herbalife.util.JSFUtil;

@ManagedBean
@ViewScoped
public class UsuarioBean {
	private Usuario usuarioLogado;
	private Usuario usuarioCadastro;
	
	public Usuario getUsuarioCadastro() {
		if(usuarioCadastro == null) {
			usuarioCadastro = new Usuario();
		}
		return usuarioCadastro;
	}

	public void setUsuarioCadastro(Usuario usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}

	public Usuario getUsuarioLogado() {
		if(usuarioLogado == null) {
			usuarioLogado = new Usuario();
		}
		return usuarioLogado;
	}
	
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	public void autenticar() {
		try{
			UsuarioDao usuarioDao = new UsuarioDao();
			usuarioDao.autenticar(usuarioLogado.getNome(), usuarioLogado.getSenha());
			if(usuarioLogado == null) {
				
			}
		}catch (RuntimeException ex) {
	
		}
	}
	public void salvarUsuario() {
		JSFUtil.mensagemSucesso("Funcionário cadastrado com sucesso!");
	}
}

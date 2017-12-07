package br.com.herbalife.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.herbalife.dao.UsuarioDao;
import br.com.herbalife.entidades.Usuario;

@ManagedBean
@SessionScoped
public class LoginBean {
	private Usuario usuarioLogado;
	
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
			usuarioDao.autenticar(usuarioLogado.getCpf(), usuarioLogado.getSenha());
			if(usuarioLogado == null) {
				
			}
		}catch (RuntimeException ex) {
	
		}
	}
}

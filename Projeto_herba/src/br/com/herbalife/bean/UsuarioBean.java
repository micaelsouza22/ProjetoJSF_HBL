package br.com.herbalife.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.herbalife.dao.UsuarioDao;
import br.com.herbalife.entidades.Usuario;
import br.com.herbalife.util.JSFUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped

public class UsuarioBean implements Serializable{
	private List<Usuario> listaUsuarios;
	private Usuario usuarioLogado;
	private Usuario usuario;
	private UsuarioDao daoUsuario;
	
	private String acao;
	private Long codigo;

	public void novo() {
		usuario = new Usuario();
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getAcao() {
		return acao;
	}
	public void setAcao(String acao) {
		this.acao = acao;
	}
	public UsuarioBean() {
		daoUsuario = new UsuarioDao();
	}
	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public UsuarioDao getDaoUsuario() {
		return daoUsuario;
	}

	public void setDaoUsuario(UsuarioDao daoUsuario) {
		this.daoUsuario = daoUsuario;
	}

	public Usuario getUsuario() {
		if (usuario == null) {
			usuario = new Usuario();
		}
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioLogado() {
		if (usuarioLogado == null) {
			usuarioLogado = new Usuario();
		}
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public void autenticar() {
		try {
			UsuarioDao usuarioDao = new UsuarioDao();
			usuarioDao.autenticar(usuarioLogado.getNome(), usuarioLogado.getSenha());
			if (usuarioLogado == null) {

			}
		} catch (RuntimeException ex) {

		}
	}

	public void preparaNovoFuncionario() {
		try {
			
			usuario = new Usuario();
			
		} catch (Exception e) {
			e.getMessage();
		}
	}
	@PostConstruct
	public void carregaDadosTabelaFuncionario() {
		
		try {
			
			listaUsuarios = daoUsuario.listar("nome");
			
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	public void salvarUsuario() {
		try {
			
			daoUsuario.salvar(usuario);
			listaUsuarios = daoUsuario.listar("nome");
			JSFUtil.mensagemSucesso("Funcionário Salvo com Sucesso!");
			
		} catch (Exception e) {
			JSFUtil.mensagemSucesso("FATAL ERRO: " + e.getMessage());
		}
	}

	public void alterarFuncionario(ActionEvent evento) {

		try {
			usuario = (Usuario) evento.getComponent().getAttributes().get("funcionarioSelecionado");
			JSFUtil.mensagemSucesso("Funcionário editado com sucesso!");
		} catch (Exception e) {
			JSFUtil.mensagemSucesso("FATAL ERRO: " + e.getMessage());
		}

	}
	public void removerFuncionario(ActionEvent evento) {
		try {
			
			usuario = (Usuario) evento.getComponent().getAttributes().get("funcionarioSelecionado");
			daoUsuario.remover(usuario.getIdusuario());
			JSFUtil.mensagemSucesso("Funcionário removido com sucesso!");
			listaUsuarios = daoUsuario.listar("nome");
			
		} catch (Exception e) {
			JSFUtil.mensagemSucesso("FATAL ERRO: " + e.getMessage());
		}
	}
}

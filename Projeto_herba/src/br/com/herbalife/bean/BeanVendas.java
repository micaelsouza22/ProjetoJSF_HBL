package br.com.herbalife.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.herbalife.dao.ItemPedidoDao;
import br.com.herbalife.dao.PedidoDao;
import br.com.herbalife.dao.TipoDePgmtDao;
import br.com.herbalife.entidades.Itempedido;
import br.com.herbalife.entidades.Pedido;
import br.com.herbalife.entidades.Tipodepagmt;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class BeanVendas implements Serializable{

	private List<Itempedido> listaItemP;
	private List<Pedido> listaPedido;
	private List<Tipodepagmt> listaTipodePgmt;
	private ItemPedidoDao daoItemPedido;
	private PedidoDao daoPedido;
	private TipoDePgmtDao daoTipoDePgmt;
	
	
	
	public BeanVendas() {
		daoItemPedido = new ItemPedidoDao();
		daoPedido = new PedidoDao();
		daoTipoDePgmt = new TipoDePgmtDao();
	}
	
	public List<Itempedido> getListaItemP() {
		return listaItemP;
	}
	public List<Pedido> getListaPedido() {
		return listaPedido;
	}
	public List<Tipodepagmt> getListaTipodePgmt() {
		return listaTipodePgmt;
	}
	
	@PostConstruct
	public void carregaDadosTablVendas() {
		listaItemP = daoItemPedido.listar("iditem");
		listaPedido = daoPedido.listar(null);
		listaTipodePgmt = daoTipoDePgmt.listar(null);
	}
	
	
	
}

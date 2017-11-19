package br.com.herbalife.principal;

import java.util.List;

import br.com.herbalife.dao.ClienteDao;
import br.com.herbalife.entidades.Cliente;

public class Principal {

	public static void main(String[] args) {
	
		ClienteDao daoCli = new ClienteDao();
		
		List<Cliente> listaCliente = daoCli.listar(null);
		
		for (Cliente cliente : listaCliente) {
			System.out.println("Nome do Cliente: " + cliente.getNomecliente());
			System.out.println("Nome do Cliente: " + cliente.getCpf());
		}

	}

}

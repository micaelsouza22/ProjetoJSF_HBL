package br.com.herbalife.principal;

import java.util.List;

import br.com.herbalife.dao.CategoriaDao;
import br.com.herbalife.dao.ClienteDao;
import br.com.herbalife.dao.ProdutoDao;
import br.com.herbalife.entidades.Categoria;
import br.com.herbalife.entidades.Cliente;
import br.com.herbalife.entidades.Produto;

public class Principal {

	public static void main(String[] args) {

		ProdutoDao daoProduto = new ProdutoDao();
		ClienteDao daoCliente = new ClienteDao();
		CategoriaDao daoCategoria = new CategoriaDao();

		List<Produto> listaProdutos = daoProduto.listar("nomeproduto");

		for (Produto produto : listaProdutos) {
			System.out.println("Nome do Produto: " + produto.getNomeproduto());
		}

		List<Cliente> listaCliente = daoCliente.listar(null);

		for (Cliente cliente : listaCliente) {
			System.out.println("Nome do Cliente: " + cliente.getNomecliente());
		}

		List<Categoria> listaCategorias = daoCategoria.listar(null);

		for (Categoria categoria : listaCategorias) {
			System.out.println("Categorias: " + categoria.getDescricao() + " | Código: " + categoria.getIdcategoria());
			
		}

	}

}

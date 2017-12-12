package br.com.herbalife.main;

import br.com.herbalife.util.EntityManagerUtil;

public class GeraTabela {
	
	public static void main(String[] args) {
		EntityManagerUtil.getEntityManager();
		EntityManagerUtil.getEntityManager().close();
	}
}

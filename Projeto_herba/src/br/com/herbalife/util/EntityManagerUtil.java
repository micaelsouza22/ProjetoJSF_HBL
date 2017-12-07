package br.com.herbalife.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SuppressWarnings("unused")
public class EntityManagerUtil {
	
	private static EntityManagerFactory factory = null;
		private static EntityManager em = null;
		
		public static EntityManager getEntityManager(){
			if (factory == null){
				factory = Persistence.createEntityManagerFactory("Projeto_herba");
			}
			if (em == null){
				em = factory.createEntityManager();
			}
			return em;			
		}		
}
package br.com.herbalife.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.herbalife.util.EntityManagerUtil;

public class GenericDao<Entidade> {

	private Class<Entidade> classe;
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public GenericDao() {
		em = EntityManagerUtil.getEntityManager();
		this.classe = (Class<Entidade>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@SuppressWarnings("unchecked")
	public List<Entidade> listar(String campo_ordenacao) {
		if(campo_ordenacao != null){
			return em.createQuery("FROM " + classe.getName() + " ORDER BY " + campo_ordenacao).getResultList();
		}else{
			return em.createQuery("FROM " + classe.getName()).getResultList();
		}
				
	}
	
	
	public boolean salvar(Entidade entidade) {
		try {
			em.getTransaction().begin();
			em.persist(entidade);
			em.getTransaction().commit();
			return true;
		}catch (Exception e) {
			System.out.println(e);
			if(em.getTransaction().isActive() == false) {
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
			return false;
		}
	}
	
	public boolean editar(Entidade entidade) {
		try {
			em.getTransaction().begin();
			em.merge(entidade);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			if(em.getTransaction().isActive() == false) {
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
			return false;
			
		}
	}
	
	public boolean remover(Integer codigo) {
		Entidade entidade = em.find(classe, codigo);
		
		try {
			em.getTransaction().begin();
			em.remove(entidade);
			em.getTransaction().commit();
			return true;
		}catch (Exception e){
			if(em.getTransaction().isActive() == false) {
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
			return false;
		}
	}
	
	public Entidade consultarPorCodigo(Integer codigo) {
		return em.find(classe, codigo);
	}
	
	@SuppressWarnings("unchecked")
	public Entidade localizarAtributo(String atributo, String campoProcurado){
		return (Entidade) em.createQuery("FROM " + classe.getName() + " WHERE "+ atributo + " = :campo")
				.setParameter("campo", campoProcurado).getSingleResult();
	}
	
}

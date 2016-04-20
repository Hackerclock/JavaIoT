package com.alessiogavioli.esempiojpa.business;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPAUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CorsoJpa");
	private EntityManager em;
	

	public JPAUtil() {
		this.em = emf.createEntityManager();
	}

	public Object insert(Object o) {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();

		return o;
	}

	public Object update(Object o) {
		em.getTransaction().begin();
		Object res = em.merge(o);
		em.getTransaction().commit();

		return res;
	}

	public void delete(Object o) {
		em.getTransaction().begin();
		em.remove(em.contains(o) ? o : em.merge(o));
		em.getTransaction().commit();
	}

	public Object load(Class<?> c, Integer id) {
		return em.find(c, id);
	}

	public List<?> runNamedQuery(String name, HashMap<String, Object> params) {
		Query query = em.createNamedQuery(name);
		if (params != null) {
			Set<String> keys = params.keySet();
			for (String k : keys) {
				query.setParameter(k, params.get(k));
			}
		}

		return query.getResultList();
	}

	public Query createQuery(String q) {
		return em.createQuery(q);
	}

	public void close() {
		em.close();
	}
}

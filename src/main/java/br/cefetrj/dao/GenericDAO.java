package br.cefetrj.dao;

import br.cefetrj.util.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class GenericDAO<T> {

    private final Class<T> entityClass;
    protected EntityManager em;

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
        this.em = HibernateUtil.getEntityManager();
    }

    public void save(T entity) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(entity);
        tx.commit();
    }

    public void update(T entity) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(entity);
        tx.commit();
    }

    public void delete(T entity) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(em.merge(entity));
        tx.commit();
    }

    public T findById(int id) {
        return em.find(entityClass, id);
    }

    public List<T> findAll() {
        return em.createQuery("from " + entityClass.getSimpleName(), entityClass).getResultList();
    }
}

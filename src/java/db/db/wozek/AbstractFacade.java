/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.db.wozek;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Ola
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
    public List<T> findq(String qrystring,String pfield1,String pdata1){
        javax.persistence.Query cq = getEntityManager().createQuery(qrystring);
        cq.setParameter(pfield1, pdata1);
        return cq.getResultList();
        
            
    }
     public List<T> findqsort(String qrystring){
        javax.persistence.Query cq = getEntityManager().createQuery(qrystring);
       
        return cq.getResultList();
        
            
    }
public List<T> findq(String qrystring, String parafield1,String paradata1,String parafield2, String paradata2)
{
    javax.persistence.Query cq;
    if(parafield1 == null){
        cq = getEntityManager().createQuery(qrystring);
    }else if (parafield2 == null){
        cq = getEntityManager().createQuery(qrystring).setParameter(parafield1, paradata1);
    } else{
        cq = getEntityManager().createQuery(qrystring).setParameter(parafield1, paradata1).setParameter(parafield2,paradata2);
    }
    return cq.getResultList();
}
    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
}

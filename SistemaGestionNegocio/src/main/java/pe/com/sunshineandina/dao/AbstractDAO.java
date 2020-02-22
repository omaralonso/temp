/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author alonsorn
 * @param <PK>
 * @param <T>
 */
public class AbstractDAO<PK extends Serializable, T> {

    private final Class<T> clasePersistente;

    public AbstractDAO() {
        this.clasePersistente = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Autowired
    private SessionFactory sessionFactory;
    
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    public T getPorPk(PK pk){
        return (T) getSession().get(clasePersistente, pk);
    }
    
    public void persist(T entity){
        getSession().persist(entity);
    }
    
    public void delete(T entity){
        getSession().delete(entity);
    }
    
    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(clasePersistente);
    }
}

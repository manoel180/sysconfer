package br.com.sysconfer.dao.imp;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import br.com.sysconfer.dao.GenericDao;

public class GenericDaoImp<T> implements GenericDao<T>{

	@PersistenceContext(type=PersistenceContextType.EXTENDED)
    protected EntityManager em;

    private Class<T> type;
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public GenericDaoImp() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }
    
	@Override
	public T save(T object) {
		em.persist(object);
        return object;
	}

	@Override
	public T update(T object) {
		em.merge(object);
		return object;
	}

	@Override
	public void delete(Object id) {
		em.remove(id);
	}

	@Override
	public T find(Object id) {
        return (T) this.em.find(type, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listAll() {
	        Query query = this.em
	                .createQuery("FROM "+ type.getSimpleName());
	        List<T> result = query.getResultList();
        return result;
	}

}

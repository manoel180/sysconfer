package br.com.sysconfer.dao;

import java.util.List;

public interface GenericDao<T> {

	T save(T object);
	T update(T object);
	void delete(Object id);
	T find(Object id);
	List<T> listAll();
}

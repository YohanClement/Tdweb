package fr.formation.inti.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T, ID> {

	private SessionFactory sessionFactory;
	protected Session session;
	public Class<T> type;

	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
		this.type = (Class<T>) genericSuperClass.getActualTypeArguments()[0];
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		this.sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		this.session = sessionFactory.getCurrentSession();
	}

	public void beginTransaction() {
		if (!session.isOpen()) {
			session = sessionFactory.openSession();
		}
		session.getTransaction().begin();
	}

	public void commit(boolean ok) {
		if (ok) {
			session.getTransaction().commit();
		} else {
			session.getTransaction().rollback();
		}
		session.close();
	}

	public T findById(ID id) {
		return session.get(type, id);
	}

	@SuppressWarnings("unchecked")

	public List<T> findAll() {
		List<T> list = session.createQuery("select t from " + type.getName() + " t").getResultList();
		list.forEach(t -> session.refresh(t));
		return list;

	}

	public T save(T entiy) {
		session.saveOrUpdate(entiy);
		return entiy;
	}

	public void delete(T entiy) {
		session.delete(entiy);

	}

	public void deleteById(ID id) {
		T t = session.get(type, id);
		session.delete(t);

	}

	public void close() {
		this.session.close();
		this.sessionFactory.close();
	}

}

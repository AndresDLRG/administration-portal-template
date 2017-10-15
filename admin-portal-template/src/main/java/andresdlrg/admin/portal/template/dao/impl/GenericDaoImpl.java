package andresdlrg.admin.portal.template.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import andresdlrg.admin.portal.template.dao.GenericDao;

@SuppressWarnings({ "unchecked", "rawtypes" })
@Component
public abstract class GenericDaoImpl<E, K extends Serializable> implements GenericDao<E, K> {

	@Autowired
	private SessionFactory sessionFactory;

	protected Class<? extends E> daoType;

	/**
	 * By defining this class as abstract, we prevent Spring from creating
	 * instance of this class If not defined as abstract,
	 * getClass().getGenericSuperClass() would return Object. There would be
	 * exception because Object class does not hava constructor with parameters.
	 */
	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		daoType = (Class) pt.getActualTypeArguments()[0];
	}

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(E entity) {
		currentSession().save(entity);
	}

	@Override
	public void saveOrUpdate(E entity) {
		currentSession().saveOrUpdate(entity);
	}

	@Override
	public void update(E entity) {
		currentSession().update(entity);
	}

	@Override
	public void remove(E entity) {
		currentSession().delete(entity);
	}

	@Override
	public E findByPK(K key) {
		return (E) currentSession().get(daoType, key);
	}

	@Override
	public List<E> getAll() {
		return currentSession().createCriteria(daoType).list();
	}

	@Override
	public void removeById(K key) {
		remove(findByPK(key));
	}

	@Override
	public E findByField(String field, Object value) {
		return (E) currentSession().createCriteria(daoType).add(Restrictions.eq(field, value)).uniqueResult();
	}

	@Override
	public List<E> findAllByField(String field, Object value) {
		return (List<E>) currentSession().createCriteria(daoType).add(Restrictions.eq(field, value)).list();
	}

	@Override
	public List<E> findAllByFieldLike(String field, Object value) {
		return (List<E>) currentSession().createCriteria(daoType).add(Restrictions.like(field, value)).list();
	}

	@Override
	public Long getCountTotal() {
		return (Long) currentSession().createCriteria(daoType).setProjection(Projections.rowCount()).uniqueResult();
	}

	@Override
	public Long getCountBySearch(String queryString) {
		return (Long) currentSession().createQuery(queryString).uniqueResult();

	}

	@Override
	public List<E> findBySearch(String queryString, int firstResult, int maxResults) {
		Query query = currentSession().createQuery(queryString).setFirstResult(firstResult).setMaxResults(maxResults);
		return (List<E>) query.list();

	}

}

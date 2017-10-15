package andresdlrg.admin.portal.template.dao;

import java.util.List;

public interface GenericDao<E, K> {

	public void add(E entity);

	public void saveOrUpdate(E entity);

	public void update(E entity);

	public void remove(E entity);

	public void removeById(K key);

	public E findByPK(K key);

	public E findByField(String field, Object value);

	public List<E> findAllByField(String field, Object value);

	public List<E> findAllByFieldLike(String field, Object value);

	public List<E> getAll();
	
	public Long getCountTotal();

	public Long getCountBySearch(String queryString);

	public List<E> findBySearch(String queryString, int firstResult, int maxResults);

}

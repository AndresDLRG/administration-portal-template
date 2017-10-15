package andresdlrg.admin.portal.template.service;

import java.util.List;
import java.util.Map;

import andresdlrg.admin.portal.template.dto.datatables.DataMapper;
import andresdlrg.admin.portal.template.dto.datatables.DataTablesRequest;
import andresdlrg.admin.portal.template.dto.datatables.DataTablesResponse;

public interface GenericService<E, K> {

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

	public DataTablesResponse<E> getPaged(DataTablesRequest dtRequest, Map<String, DataMapper> map, String className,
			String datePattern);
}

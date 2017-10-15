package andresdlrg.admin.portal.template.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import andresdlrg.admin.portal.template.dao.GenericDao;
import andresdlrg.admin.portal.template.dto.datatables.DataMapper;
import andresdlrg.admin.portal.template.dto.datatables.DataTablesRequest;
import andresdlrg.admin.portal.template.dto.datatables.DataTablesResponse;
import andresdlrg.admin.portal.template.service.GenericService;

@Service
public abstract class GenericServiceImpl<E, K> implements GenericService<E, K> {

	private GenericDao<E, K> genericDao;

	public GenericServiceImpl(GenericDao<E, K> genericDao) {
		this.genericDao = genericDao;
	}

	public GenericServiceImpl() {
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void add(E entity) {
		genericDao.add(entity);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveOrUpdate(E entity) {
		genericDao.saveOrUpdate(entity);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(E entity) {
		genericDao.update(entity);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void remove(E entity) {
		genericDao.remove(entity);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void removeById(K key) {
		genericDao.removeById(key);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public E findByPK(K key) {
		return genericDao.findByPK(key);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public E findByField(String field, Object value) {
		return genericDao.findByField(field, value);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<E> findAllByField(String field, Object value) {
		return genericDao.findAllByField(field, value);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<E> findAllByFieldLike(String field, Object value) {
		return genericDao.findAllByFieldLike(field, value);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<E> getAll() {
		return genericDao.getAll();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public DataTablesResponse<E> getPaged(DataTablesRequest dtRequest, Map<String, DataMapper> map, String className,
			String datePattern) {

		int columnToOrder = dtRequest.getOrders().get(0).getColumn();
		String searchValue = dtRequest.getSearch().getValue();
		DataMapper mapper = map.get(dtRequest.getColumns().get(columnToOrder).getData());
		String dir = dtRequest.getOrders().get(0).getDir();

		StringBuilder searchQuery = new StringBuilder("from ").append(className).append(" x where 1=1 ");
		if (searchValue != null && !"".equals(searchValue)) {
			if (mapper.getClazz().isAssignableFrom(Date.class)) {
				searchQuery.append(" and to_char(").append(mapper.getFieldName()).append(", '").append(datePattern)
						.append("') like '%").append(searchValue).append("%' ");
			} else {
				searchQuery.append(" and cast(x.").append(mapper.getFieldName()).append(" as string) like '%")
						.append(searchValue).append("%' ");
			}
		}
		StringBuilder countQuery = new StringBuilder("select count(*) ").append(searchQuery.toString());
		searchQuery.append(" order by ").append(mapper.getFieldName()).append(" ").append(dir);

		long recordsTotal = genericDao.getCountTotal();
		long recordsFiltered = genericDao.getCountBySearch(countQuery.toString());
		List<E> list = genericDao.findBySearch(searchQuery.toString(), dtRequest.getStart(), dtRequest.getLength());

		return new DataTablesResponse<>(dtRequest.getDraw(), recordsTotal, recordsFiltered, "", list);
	}
}

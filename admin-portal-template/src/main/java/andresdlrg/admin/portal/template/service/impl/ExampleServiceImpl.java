package andresdlrg.admin.portal.template.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import andresdlrg.admin.portal.template.dao.impl.ExampleDaoImpl;
import andresdlrg.admin.portal.template.dto.datatables.DataMapper;
import andresdlrg.admin.portal.template.dto.datatables.DataTablesRequest;
import andresdlrg.admin.portal.template.dto.datatables.DataTablesResponse;
import andresdlrg.admin.portal.template.model.Example;
import andresdlrg.admin.portal.template.service.ExampleService;

@Transactional
@Service("exampleServiceImpl")
public class ExampleServiceImpl extends GenericServiceImpl<Example, Long> implements ExampleService {

	@Autowired
	public ExampleServiceImpl(@Qualifier("exampleDaoImpl") ExampleDaoImpl genericDao) {
		super(genericDao);
	}

	@Override
	public DataTablesResponse<Example> getPaged(DataTablesRequest dtRequest) {
		DataMapper mapper1 = new DataMapper("id", Long.class);
		DataMapper mapper2 = new DataMapper("someString", String.class);
		DataMapper mapper3 = new DataMapper("startDate", Date.class);

		Map<String, DataMapper> map = new HashMap<>();
		map.put("id", mapper1);
		map.put("someString", mapper2);
		map.put("startDate", mapper3);

		return getPaged(dtRequest, map, "Example", "yyyy-mm-DD");
	}

}

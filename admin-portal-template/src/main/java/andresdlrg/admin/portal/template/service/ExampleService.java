package andresdlrg.admin.portal.template.service;

import andresdlrg.admin.portal.template.dto.datatables.DataTablesRequest;
import andresdlrg.admin.portal.template.dto.datatables.DataTablesResponse;
import andresdlrg.admin.portal.template.model.Example;

public interface ExampleService extends GenericService<Example, Long>{

	public DataTablesResponse<Example> getPaged(DataTablesRequest dtRequest);
}

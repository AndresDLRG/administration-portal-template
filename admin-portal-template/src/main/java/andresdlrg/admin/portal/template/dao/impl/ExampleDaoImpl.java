package andresdlrg.admin.portal.template.dao.impl;

import org.springframework.stereotype.Repository;

import andresdlrg.admin.portal.template.dao.ExampleDao;
import andresdlrg.admin.portal.template.model.Example;

@Repository("exampleDaoImpl")
public class ExampleDaoImpl extends GenericDaoImpl<Example, Long> implements ExampleDao {

}

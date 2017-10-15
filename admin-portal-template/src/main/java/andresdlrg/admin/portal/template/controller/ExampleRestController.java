package andresdlrg.admin.portal.template.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import andresdlrg.admin.portal.template.dto.datatables.DataTablesRequest;
import andresdlrg.admin.portal.template.dto.datatables.DataTablesResponse;
import andresdlrg.admin.portal.template.model.Example;
import andresdlrg.admin.portal.template.service.ExampleService;

@RestController
@RequestMapping("/api/example")
public class ExampleRestController {

	private static Logger log = LoggerFactory.getLogger(ExampleRestController.class);

	@Autowired
	private ExampleService exampleService;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Example> getSingle(@PathVariable Long id) {
		try {
			Example example = exampleService.findByPK(id);
			return new ResponseEntity<>(example, HttpStatus.OK);
		} catch (Exception e) {
			log.error("", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Example>> getAll() {
		try {
			List<Example> list = exampleService.getAll();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.error("", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "paged", method = RequestMethod.POST)
	public ResponseEntity<DataTablesResponse<Example>> getPaged(@RequestBody DataTablesRequest dtRequest) {

		DataTablesResponse<Example> response = exampleService.getPaged(dtRequest);
		
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Example> save(@RequestBody Example example) {
		try {
			example.setId(null);
			exampleService.saveOrUpdate(example);
			return new ResponseEntity<>(example, HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Example example) {
		try {
			Example ex = exampleService.findByPK(id);
			if (ex == null) {
				return new ResponseEntity<>("Resource does not exist", HttpStatus.CONFLICT);
			}
			ex.setSomeString(example.getSomeString());
			ex.setStartDate(example.getStartDate());
			exampleService.update(ex);
			return new ResponseEntity<>("", HttpStatus.OK);
		} catch (Exception e) {
			log.error("", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable Long id) {
		try {
			exampleService.removeById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			log.error("", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

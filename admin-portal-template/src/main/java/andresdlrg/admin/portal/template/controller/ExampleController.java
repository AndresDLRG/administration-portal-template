package andresdlrg.admin.portal.template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example")
public class ExampleController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView ini() {
		return new ModelAndView("pages/example");
	}
	
}

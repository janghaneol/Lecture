package namoo.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RequestParamController {
	
	@GetMapping("/param")
	@ResponseBody
	public String param(@RequestParam("name") String name, 
						@RequestParam("age") int age) {
		return "이름 : "+name+", 나이 :" +age;
	}
}

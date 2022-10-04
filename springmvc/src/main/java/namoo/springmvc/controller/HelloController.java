package namoo.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		// view컨트롤러 
		return "hello";
	}
	
	
	@RequestMapping("/hello2")
	public ModelAndView hello2() {
		ModelAndView mav = new ModelAndView();
		String name = "장한얼";
		mav.addObject("name", name);
		mav.setViewName("hello2");
		return mav;
	}
	
	@RequestMapping("/hello3")
	public String hello3(Model model) {
		String name = "장한얼";
		model.addAttribute("name",name);
		return "hello2";
	}
	
	@RequestMapping(value="/form", method = RequestMethod.GET)
	public String form() {
		return "form";
	}
}

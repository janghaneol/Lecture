package namoo.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		// ������ �۾�
		// view�� ���� �̸� ��ȯ
		return "hello";
	}
	
	
	@RequestMapping("/hello2")
	public ModelAndView hello2() {
		ModelAndView mav = new ModelAndView();
		String name = "���Ѿ�";
		mav.addObject("name", name);
		mav.setViewName("hello2");
		return mav;
	}
	
	@RequestMapping("/hello3")
	public String hello3(Model model) {
		String name = "���Ѿ�";
		model.addAttribute("name",name);
		return "hello2";
	}
}

package namoo.springmvc.controller;

import java.util.Locale;
import java.util.Map;

import org.springframework.cglib.core.Local;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import namoo.springmvc.dto.Dog;

@Controller
public class RequestParamController2 {
	
//	@GetMapping("/param")
//	@ResponseBody
//	public String param(@RequestParam("name") String name, 
//						@RequestParam("age") int age) {
//		return "�̸� : "+name+", ���� :" +age;
//	}
	@PostMapping("/param2")
	@ResponseBody
	public String param(@RequestParam Map<String, Object> paramMap) {
		return "이름 : "+paramMap.get("name")+", 나이 :" + paramMap.get("age");
	}
	
	@PostMapping("/param3")
	public String param(@ModelAttribute("dog") Dog dog) {
		System.out.println(dog.toString());
		return "view";
	}
	
	
	@GetMapping("/param4")
	@ResponseBody
	public String param(HttpMethod method, Locale locale, 
						@RequestHeader MultiValueMap<String, String> header,
						@RequestHeader("host") String host,
						@CookieValue(value = "userId", required = false, defaultValue = "guest" )String userId) {
		System.out.println(method);
		System.out.println(locale);
		System.out.println(header);
		System.out.println(host);
		System.out.println(userId);
		return "host : " + host;
	}
	
	/*
	 * 1. 정적인 서비스
	 * 2. 동적인 서비스 (Rest API를 이용하여 URL을 직관적이게 꾸려줌) 
	 * 스프링에선 RestController를 사용하면 해당 컨트롤러 메소드를 모두 @ResponseBody에 적용되는 효과가 있다.
	 * */
	@GetMapping("/classes/{classId}/students/{studentId}")
	@ResponseBody
	public String param(@PathVariable String classId, @PathVariable String studentId) {
		return "반 번호 : "+classId+", 학번 : "+studentId;
	}
}

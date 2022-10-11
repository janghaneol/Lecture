package namoo.springmvc.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import namoo.springmvc.dto.user.User;
import namoo.springmvc.service.user.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// 회원 목록 처리
	@GetMapping
	public String list(Model model) {
		List<User> list = userService.findUsers();
		model.addAttribute("list", list);
		return "user/users";
	}
	
	// 회원 상세보기
	@GetMapping("/{id}")
	public String view(@PathVariable String id, @RequestParam(value = "result", required = false) boolean result , Model model) {
		User user = userService.findUser(id);
		model.addAttribute("user", user);
		model.addAttribute("result", result);
		return "user/view";
	}
	
		//회원등록 화면 처리
		@GetMapping("/regist")
		public String form() {
			return "user/regist";
		}
		
		//회원 등록 처리
		@PostMapping("/regist")																		// RedirectAttributes 는 리다이렉트해주면서 파라미터값을 넘겨준다.
		public String regist(@ModelAttribute User user, RedirectAttributes redirectAttributes) {	// ModelAttribute는 객체의 첫글자를 소문자로 바꿔서 저장까지하고, 생성까지한다
			userService.registUser(user);
			User createUser = userService.findUser(user.getId());
			redirectAttributes.addAttribute("id", createUser.getId());			//"id" 로 redirect할 때 해당 값을 넘겨줄 수 있다.
			redirectAttributes.addAttribute("name", createUser.getName());
			redirectAttributes.addAttribute("email", createUser.getEmail());
			redirectAttributes.addAttribute("regdate", createUser.getRegdate());
			redirectAttributes.addAttribute("result", true);
//			return "redirect:/users/view?id=xxx&name=???&email=????"; --> Redirect를 무식하게 할 경우 URL이 굉장히 지저분해진다.
			return "redirect:/users/{id}";	// Redirect할때 생성된값이 쿼리스트링으로 자동으로 넘어간다.
		}
}


















package namoo.springjpa.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

import lombok.extern.slf4j.Slf4j;
import namoo.springjpa.entity.user.User;
import namoo.springjpa.repository.user.SpringDataJpaUserRepository;

@Controller
@RequestMapping("/users")
@Slf4j
public class UserController {
	
	@Autowired
	private SpringDataJpaUserRepository jpaRepository;
	
	// 회원 목록 처리
	@GetMapping
	public String list(@PageableDefault(size=10, page = 0) Pageable pageable ,
			@RequestParam(required = false, defaultValue = "") String value,
			Model model) {
		Page<User> pageResult = jpaRepository.findAllByIdContainingOrEmailContaining(value, value, pageable);
		
		int pageNumber = pageResult.getPageable().getPageNumber()+1;
		int totalPage = pageResult.getTotalPages();
		int pageBlock = 5;
		int startBlockPage = ((pageNumber)/pageBlock)*pageBlock+1;
		int endBlockPage = startBlockPage+pageBlock-1;
		endBlockPage = endBlockPage>totalPage ? totalPage : endBlockPage;
		
		
		log.info("회원 목록 요청 : {}, {}" , pageable.getPageSize(), pageable.getPageNumber());
		model.addAttribute("pageResult", pageResult);
		model.addAttribute("startBlockPage", startBlockPage);
		model.addAttribute("endBlockPage", endBlockPage);
		return "user/users";
	}
	
}


















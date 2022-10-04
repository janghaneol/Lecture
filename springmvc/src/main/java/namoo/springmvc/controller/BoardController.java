package namoo.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	// 글쓰기화면 처리
	@GetMapping("/regist")
	public String form() {
		return "board/form";
	}
	
	// 글쓰기처리
	@PostMapping("/regist")
	public String regist() {
		return "board/regist";
	}
	
	// 게시글 목록 처리
	@GetMapping("/list")
	public String list() {
		return "board/list";
	}
	
	// 게시글 삭제 처리(Admin만 가능한)
	@DeleteMapping(value = "/delete", params = "admin=bangry")
	@ResponseBody
	public String delete() {
		return "<h2>게시판 삭제 완료</h2>";
	}
	
	// 헤더 조건 매핑
		@GetMapping(value = "/header", headers = "mode=debug")
		@ResponseBody
		public String headerMapping() {
			return "디버깅모드 실행...";
		}
}

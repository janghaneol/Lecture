package namoo.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController를 이용한 예제
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/boards")
public class RestBoardController {
	
	// 게시판 목록 처리
	@GetMapping
	public String list() {
		return "게시판 목록 처리 OK";
	}
	// 게시판 등록 처리
	@PostMapping
	public String regist() {
		return "게시판 등록 OK";
	}
	
	// 게시글 상세 조회 처리
	@GetMapping("/{boardId}")
	public String find(@PathVariable String boardId) {
		return boardId+"게시글 검색 OK";
	}
	
	// 게시글 수정
	@PatchMapping("/{boardId}")
	public String update(@PathVariable String boardId) {
		return boardId + "게시글 수정 OK";
	}
	
	// 게시글 삭제 처리(Admin만 가능한)
	@DeleteMapping("/{boardId}")
	public String delete(@PathVariable String boardId) {
		return boardId+"게시글 삭제 완료";
	}

}

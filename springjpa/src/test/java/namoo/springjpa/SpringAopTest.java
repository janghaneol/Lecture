package namoo.springjpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import namoo.springjpa.service.MemberService;

@SpringBootTest
@Slf4j
public class SpringAopTest {
	@Autowired
	MemberService memberService;

	@Test
	public void test() {
		memberService.biz1();
	}
	
	@Test
	public void test2() {
		memberService.biz2();
	}
}

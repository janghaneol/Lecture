package namoo.springtx;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import namoo.springtx.service.BasicService;

@SpringBootTest
@Slf4j
public class BasicServiceTxTest {
	/* 실제 서비스 객체 대신 트랜잭션을 처리해주는 프록시 객체가 스프링빈에 등록되고,
	 * 주입받을때도 실제 서비스객체 대신 프록시객체가 주입*/
	@Autowired
	BasicService basicService;
	
	// AOP프록시 객체 확인
	@Test
	public void checkProxy() {
		Object proxy = basicService.getClass();
		log.info("proxy 객체 : {}", proxy);
	}
	
	@Test
	public void proxy() {
		basicService.nonTxMethod();
		basicService.txMethod();
	}
}

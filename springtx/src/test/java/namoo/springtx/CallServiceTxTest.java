package namoo.springtx;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import namoo.springtx.service.CallService;

@SpringBootTest
@Slf4j
public class CallServiceTxTest {
	@Autowired
	CallService callService;
	
	@Test
	public void printProxy() {
		log.info("callService class = {}",callService.getClass());
	}
	
	@Test
	public void internalCall() {
		callService.internal();
	}
	
	@Test
	public void externalCall() {
		callService.external();
	}
}

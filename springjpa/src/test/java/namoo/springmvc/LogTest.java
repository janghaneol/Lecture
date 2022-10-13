package namoo.springmvc;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class LogTest {
	
	Logger logger = LoggerFactory.getLogger(LogTest.class);
	
	String name = "장한얼";
	
	@Test
	void LogTest() {
		logger.trace("trace 출력 : {} {}", name, name);
		logger.debug("debug 출력 : {}", name);
		logger.info("info 출력   : {}", name);
		logger.warn("warn 출력   : {}", name);
		logger.error("error 출력 : {}", name);
		
	}
}







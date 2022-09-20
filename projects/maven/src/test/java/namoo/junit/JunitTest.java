package namoo.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class JunitTest {
	
	SomeServiceImpl service;
	
	@BeforeEach
	public void setUp() {
		System.out.println("setUp() Called");
		service = new SomeServiceImpl();
	}
	
	@Test
	@Disabled
	public void sumTest() {
//		service.sum(10,20);
		assertEquals(30, service.sum(10, 20));
	}
	
	@Test
	public void sumTest2() {
//		System.out.println(service);
		assertNotNull(service);
	}
	
	@Test
	@Timeout(value = 3)
	@Disabled
	public void checkTimeout() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@ParameterizedTest
	@ValueSource(ints = {10,20,30})
	public void parameterTest(int value) {
		System.out.println("전달받은 값 : "+ value );
	}
	
	@AfterEach
	public void destroy() {
		System.out.println("테스트 메소드 실행 후 실행되는 메소드");
	}
	
	
	
}

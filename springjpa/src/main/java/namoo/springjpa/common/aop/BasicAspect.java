package namoo.springjpa.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BasicAspect {
	
	@Before("execution(* namoo.springjpa.service..*(..))")
	public void startLog() {
		System.out.println("======= 비즈니스 메소드 실행 전 =========");
	}
	
	@After("execution(* namoo.springjpa.service..*(..))")
	public void endLog() {
		System.out.println("======= 비즈니스 메소드 실행 후 =========");
	}
	
	@AfterReturning(pointcut = "execution(* namoo.springjpa.service..*(..))", returning = "returnValue")
	public void afterReturning(JoinPoint joinpoint, Object returnValue) {
		System.out.println(">>>실행 메소드 반환 값 : "+ returnValue);
	}
	
	@AfterThrowing(pointcut = "execution(* namoo.springjpa.service..*(..))", throwing = "exception")
	public void afterThrowingLog(JoinPoint joinpoint, Throwable exception) {
		System.out.println(">>>"+joinpoint.getSignature().toShortString()+" 메소드 예외 발생 : " + exception);
	}
}

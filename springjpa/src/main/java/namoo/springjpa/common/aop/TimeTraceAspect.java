package namoo.springjpa.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 공통 관심(로직) 기능 정의
 * @author Administrator
 *
 */

@Component
@Aspect
public class TimeTraceAspect {
	/* 적용할 Advice 정의 */
	@Around("execution(* namoo.springjpa..*(..))")
	public Object methodTimeTrace(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		String bizObject = joinPoint.getTarget().getClass().getName();
		String bizMethod = joinPoint.getSignature().toShortString();
		System.out.println(">>>>>"+bizObject+" 객체의 "+bizMethod+" 메소드 START<<<<<");
		
		/* 실제 비즈니스 객체의 메소드 호출*/
		try {
			return joinPoint.proceed();
		}
		
		finally {
			long finish = System.currentTimeMillis();
			long timems = finish-start;
			System.out.println(">>>>>실행시간 : " + timems + "ms<<<<<");
			System.out.println(">>>>>"+bizObject+" 객체의 "+bizMethod+" 메소드 END<<<<<");
			
			
		}
	}
}

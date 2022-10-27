package namoo.springtx.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BasicService {
	/* 트랜잭션 AOP 적용대상. (@Transactional로 지정)*/	
	@Transactional
	public void txMethod() {
		log.info("txMethod()실행 ...");
		/* 현재 쓰레드에 트랜잭션이 적용되어있는지 확인.
		 * 결과가 true면 트랜잭션이 적용됨을 의미*/
		boolean txActive = TransactionSynchronizationManager.isActualTransactionActive();
		log.info("트랜잭션 Active {} : ", txActive);
	}
	/*트랜잭션이 적용되어있지 않은 메소드*/
	public void nonTxMethod() {
		log.info("nonTxMethod()실행 ...");
		
		boolean txActive = TransactionSynchronizationManager.isActualTransactionActive();
		log.info("트랜잭션 Active {} : ", txActive);
	}
}

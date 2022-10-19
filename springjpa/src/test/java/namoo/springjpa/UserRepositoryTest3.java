package namoo.springjpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;

import lombok.extern.slf4j.Slf4j;
import namoo.springjpa.entity.user.User;
import namoo.springjpa.repository.user.SpringDataJpaUserRepository;
import namoo.springjpa.repository.user.UserRepository;

@Transactional
@Slf4j
@SpringBootTest
class UserRepositoryTest3 {

	@Autowired
	SpringDataJpaUserRepository userRepository;

	//
	@Test
	@Disabled
	public void findAllByNameStartingWith() {

		List<User> findUser = userRepository.findAllByNameContaining("기정");
		for (User user : findUser) {
			log.info("NameContaining으로 검색된 회원 정보 : {}", user);
		}
	}

	// 옵션으로 검색
	@Test
	@Disabled
	public void findAllOptions() {
		String searchValue = "한얼짱";
		String searchType = "id";

		switch (searchType) {
		case "id":
			Optional<User> optional = userRepository.findById(searchValue);
			if (optional.isPresent()) {
				User findUser = optional.get();
				log.info("ID로 검색된 회원의 정보 : {}", findUser);
			} else {
				log.info("조회된 정보가 없습니다.");
			}
			break;

		case "name":
			List<User> list = userRepository.findAllByNameContaining(searchValue);
			for (User user : list) {
				log.info("name으로 검색된 회원 목록 : {}", user);
			}
			break;

		default:
			List<User> listAll = userRepository.findAll();
			for (User user : listAll) {
				log.info("전체 회원 목록 : {}", user);
			}
			break;
		}
	}

	@Test
	@Disabled
	public void findAllByRegdateGreaterThanEqual() throws ParseException {
		String regDate = "22/10/10";
		Date searchRegDate = new SimpleDateFormat("yy/mm/dd").parse(regDate);
		List<User> list = userRepository.findAllByRegdateGreaterThanEqual(searchRegDate);
		log.info("{} 보다 늦게 등록된 회원의 수 : {} , 정보 : {}", regDate, list.size(), list);
	}

	@Test
	@Disabled
	public void findAllByRegdateBetween() throws ParseException {
		Date startDate = new SimpleDateFormat("yy/mm/dd").parse("22/10/13");
		Date endDate = new SimpleDateFormat("yy/mm/dd").parse("22/10/17");
		List<User> list = userRepository.findAllByRegdateBetween(startDate, endDate);
		log.info("{} 에서 {} 에 등록된 회원의 수 : {}, 정보 : {}", startDate, endDate, list.size(), list);
	}

	@Test
	@Disabled
	public void login() {
		String id = "bangry";
		String passwd = "3333";

		User user = userRepository.findByIdAndPasswd(id, passwd);
		log.info("입력하신 ID {}의 정보 : {}", id, user);
	}

	@Test
	@Disabled
	public void sort() {
		// 전체 리스트 Sort
//		List<User> list = userRepository.findAll(Sort.by("id").ascending());
		
		// 검색된 값 내에서 정렬
		List<User> list = userRepository.findAllByNameContaining("", Sort.by("name").and(Sort.by("email")));
		for (User user : list) {
			log.info("정렬된 리스트 : {}", user);
		}
	}
	
	@Test
	public void findAllPaging() {
		Sort sort = Sort.by("id");
		Pageable pageable = PageRequest.of(2, 5, sort);
		Page<User> pageResults = userRepository.findAll(pageable);
		
		log.info("목록 : {}" , pageResults.getContent());
		log.info("전체목록 개수: {}" , pageResults.getTotalElements());
		log.info("현재페이지 목록 개수: {}" , pageResults.getNumberOfElements());
		log.info("전체페이지 개수: {}" , pageResults.getTotalPages());
		log.info("페이지당 목록 개수 {}: " , pageResults.getSize());
		log.info("현재 페이지 {}: " , pageResults.getNumber());
		log.info("처음으로 존재여부 {}: " , pageResults.isFirst());
		log.info("이전페이지 존재여부 {}: " , pageResults.hasPrevious());
		log.info("다음페이지 존재여부 {}: " , pageResults.hasNext());
		log.info("마지막으로 존재여부 {}: " , pageResults.isLast());
	}
	
	@Test
	@Disabled
	public void findAllByIdContainingOrEmailContaining() {
		String searchValue = "n";
		Pageable pageable = PageRequest.of(0,5);
		Page<User> pageResults = userRepository.findAllByIdContainingOrEmailContaining(searchValue, searchValue, pageable);
		List<User> list = pageResults.getContent();
		
		for (User page : list) {
			log.info("목록 : {}" , page);
		}
		log.info("전체 목록 갯수 : {}", pageResults.getTotalElements());
		log.info("현재 페이지 목록 갯수 : {}", pageResults.getNumberOfElements());
		log.info("전체 페이지 수 : {}", pageResults.getTotalPages());
	}
}

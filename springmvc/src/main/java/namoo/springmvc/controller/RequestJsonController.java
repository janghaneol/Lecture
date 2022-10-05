package namoo.springmvc.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import namoo.springmvc.dto.Dog;

@Controller
public class RequestJsonController {
	
	@PostMapping("/request-json")
	@ResponseBody
	public String requestJson(@RequestBody String jsonMessage) throws IOException{
		System.out.println(jsonMessage);
		ObjectMapper objectMapper = new ObjectMapper();
		Dog dog = objectMapper.readValue(jsonMessage, Dog.class);
		System.out.println(dog);
		return dog.getName();
	}
	
	@PostMapping("/request-json2")
	@ResponseBody
	public Dog requestJson(@RequestBody Dog dog) throws IOException{
		System.out.println(dog);
		// DB에 인서트하는 경우에 용이함.
		return dog;
	}
	
}

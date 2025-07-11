package kr.co.sist.day0707;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InterceptorController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}//index
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}//hello
	
	@GetMapping("/bye")
	public String bye() {
		return "bye";
	}//bye

}//class

package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeaderController {
	@RequestMapping("/header/check.do")
	public String check(@RequestHeader("Accept-Language") String languageHeader) {
		 //getHeader을 편리하게 어노테이션만 사용하여 볼수있다.(API를 사용하지 않고도) @RequestHeader("Accept-Language") 
		System.out.println(languageHeader);
		return "header/pass";
	}

}

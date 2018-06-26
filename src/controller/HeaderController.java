package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeaderController {
	@RequestMapping("/header/check.do")
	public String check(@RequestHeader("Accept-Language") String languageHeader) {
		 //getHeader�� ���ϰ� ������̼Ǹ� ����Ͽ� �����ִ�.(API�� ������� �ʰ�) @RequestHeader("Accept-Language") 
		System.out.println(languageHeader);
		return "header/pass";
	}

}

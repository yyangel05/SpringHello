package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CookieController {
	@RequestMapping("/cookie/make.do") //쿠키를 만든다
	public String make(HttpServletResponse response) {
		response.addCookie(new Cookie("auth","asd")); //make.do가 실행되면 auth에 1이름의 쿠키 생성?
		/*response.addCookie(new Cookie("auth","맛있는쿠키"));*/ //한글쿠키는 안되나? 실행하면 오류뜨던데
		return "cookie/made";
	}
	
	@RequestMapping("/cookie/view.do") //클라이언트가 가져온 쿠키를 분석한다
	public String view(@CookieValue(value="auth", defaultValue="0") String auth) { //쿠키가 존재하지 않을 경우 auth파라미터는 0을 값으로 가짐.
		System.out.println("auth 쿠키: " + auth); //쿠키 내용 출력
		return "cookie/view";
	}
}

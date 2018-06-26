package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CookieController {
	@RequestMapping("/cookie/make.do") //��Ű�� �����
	public String make(HttpServletResponse response) {
		response.addCookie(new Cookie("auth","asd")); //make.do�� ����Ǹ� auth�� 1�̸��� ��Ű ����?
		/*response.addCookie(new Cookie("auth","���ִ���Ű"));*/ //�ѱ���Ű�� �ȵǳ�? �����ϸ� �����ߴ���
		return "cookie/made";
	}
	
	@RequestMapping("/cookie/view.do") //Ŭ���̾�Ʈ�� ������ ��Ű�� �м��Ѵ�
	public String view(@CookieValue(value="auth", defaultValue="0") String auth) { //��Ű�� �������� ���� ��� auth�Ķ���ʹ� 0�� ������ ����.
		System.out.println("auth ��Ű: " + auth); //��Ű ���� ���
		return "cookie/view";
	}
}

package controller;

import javax.validation.Valid;

import service.AuthenticationException;
import service.Authenticator;
import service.LoginCommand;
import validator.LoginCommandValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/login/login.do")
public class LoginController {
	private String formViewName = "login/form";
	
	@Autowired //처음에 bean에서 설정된 객체를 class에 대입하는것. //의존관계 타입으로 자동설정. setter가 필요없다
	private Authenticator authenticator;
	
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return formViewName;
	}
	
	@ModelAttribute 
	public LoginCommand formBacking() {
		return new LoginCommand();
	}
	
	@RequestMapping(method = RequestMethod.POST) 
	public String submit(@Valid LoginCommand loginCommand, BindingResult result) {  //@Valid -연결- new LoginCommandValidator() 저 아래서 유효성검증!
		//에러가 있으면 
		if(result.hasErrors()) {
			return formViewName;
		}
		
		try {
			authenticator.authenticate(loginCommand);
			return "redirect:/index.jsp"; //로그인이 성공하면 index.jsp로 넘어간다.
		} catch(AuthenticationException e) {
			//로그인을 수행하다가 오류가 발생하면 catch문에서 이렇게 조치를 취하게 한다
			result.reject("invalidIdOrPassword", new Object[] { 
					loginCommand.getUserId() 
			},null);
			
			return formViewName;
		}
		
	}
	
	@InitBinder  //유효성검증을 해준다?
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new LoginCommandValidator()); //유효성 검증을 하는 객체 생성
	}
	
	public void setAuthenticator(Authenticator loginService) {
		this.authenticator = loginService;
	}
	

}

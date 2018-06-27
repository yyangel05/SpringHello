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
	
	@Autowired //ó���� bean���� ������ ��ü�� class�� �����ϴ°�. //�������� Ÿ������ �ڵ�����. setter�� �ʿ����
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
	public String submit(@Valid LoginCommand loginCommand, BindingResult result) {  //@Valid -����- new LoginCommandValidator() �� �Ʒ��� ��ȿ������!
		//������ ������ 
		if(result.hasErrors()) {
			return formViewName;
		}
		
		try {
			authenticator.authenticate(loginCommand);
			return "redirect:/index.jsp"; //�α����� �����ϸ� index.jsp�� �Ѿ��.
		} catch(AuthenticationException e) {
			//�α����� �����ϴٰ� ������ �߻��ϸ� catch������ �̷��� ��ġ�� ���ϰ� �Ѵ�
			result.reject("invalidIdOrPassword", new Object[] { 
					loginCommand.getUserId() 
			},null);
			
			return formViewName;
		}
		
	}
	
	@InitBinder  //��ȿ�������� ���ش�?
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new LoginCommandValidator()); //��ȿ�� ������ �ϴ� ��ü ����
	}
	
	public void setAuthenticator(Authenticator loginService) {
		this.authenticator = loginService;
	}
	

}

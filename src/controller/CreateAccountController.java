package controller;

import javax.servlet.http.HttpServletRequest;

import model.Address;
import model.MemberInfo;
import validator.MemberInfoValidator;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/account/create.do")
public class CreateAccountController {
	
	@ModelAttribute("command")
	public MemberInfo formBacking(HttpServletRequest request) {
		if(request.getMethod().equalsIgnoreCase("GET")) { //Ŭ���̾�Ʈ�� ��û�� ���۹���� �̾Ƴ���. get����̷α���
			
			MemberInfo mi = new MemberInfo(); //mi��� �̸��� MemberInfo �ڹٺ�ü�� �����Ѵ�.
			Address address = new Address(); //address��� �̸��� Address �ڹٺ�ü�� �����Ѵ�.
			address.setZipcode(autoDetectZipcode(request.getRemoteAddr())); //address�� zipcode�� 000000���� �����Ѵ�. 
			mi.setAddress(address); //mi��ü�� �ּҸ� �����Ѵ�.
			return mi;
		} 
		else {
			return new MemberInfo();
		}
	}
	
	private String autoDetectZipcode(String remoteAddr) {
		return "000000";
	}
	
	@RequestMapping(method = RequestMethod.GET)  //get����� ��û�̸� creationForm.jsp�� ����.
	public String form() {
		return "account/creationForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)  //post����� ��û�̸� created.jsp�� ����.
	public String submit(@ModelAttribute("command") MemberInfo memberInfo, BindingResult result) { //jsp���� ������ ���� �̸��� command
		new MemberInfoValidator().validate(memberInfo, result);
		if(result.hasErrors()) {
			return "account/creationForm";
		}
		
		return "account/created";
	}
	

}

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
		if(request.getMethod().equalsIgnoreCase("GET")) { //클라이언트가 요청한 전송방식을 뽑아낸다. get방식이로구만
			
			MemberInfo mi = new MemberInfo(); //mi라는 이름의 MemberInfo 자바빈객체를 생성한다.
			Address address = new Address(); //address라는 이름의 Address 자바빈객체를 생성한다.
			address.setZipcode(autoDetectZipcode(request.getRemoteAddr())); //address의 zipcode를 000000으로 세팅한다. 
			mi.setAddress(address); //mi객체의 주소를 세팅한다.
			return mi;
		} 
		else {
			return new MemberInfo();
		}
	}
	
	private String autoDetectZipcode(String remoteAddr) {
		return "000000";
	}
	
	@RequestMapping(method = RequestMethod.GET)  //get방식의 요청이면 creationForm.jsp를 실행.
	public String form() {
		return "account/creationForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)  //post방식의 요청이면 created.jsp를 실행.
	public String submit(@ModelAttribute("command") MemberInfo memberInfo, BindingResult result) { //jsp에서 가져다 쓰는 이름은 command
		new MemberInfoValidator().validate(memberInfo, result);
		if(result.hasErrors()) {
			return "account/creationForm";
		}
		
		return "account/created";
	}
	

}

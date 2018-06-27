package validator;

import service.LoginCommand;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

//Validator인터페이스를 구현한 LoginCommandValidator클래스
public class LoginCommandValidator implements Validator { 
	
	@Override 
	//Validator가 해당 Class에 대한 값 검증을 지원하는지 여부를 리턴한다.
	public boolean supports(Class<?> clazz) {
		return LoginCommand.class.isAssignableFrom(clazz);
	}
	
	@Override 
	//target객체에 대한 검증을 실행하고, 검증결과 문제가 있을 때에는 errors객체에 어떤 문제인지에 대한 정보를 저장
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
		
		//ValidationUtils클래스의 rejectIfEmptyOrWhitespace함수를 이용해서 검증한다.
		//(결과를 담는 객체인가?,확인하고자 하는 필드명,에러코드)
	}

}

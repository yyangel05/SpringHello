package validator;

import model.Address;
import model.MemberInfo;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class MemberInfoValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return MemberInfo.class.isAssignableFrom(clazz);
	}
	
	//유효성검증을 서버의 스프링에서 하고 있다. <->클라이언트에서 자바스크립트로 검증하는방법??
	@Override
	public void validate(Object target, Errors errors) { //유효성을 검증하는 validate()메서드
		MemberInfo memberInfo = (MemberInfo) target;
		if(memberInfo.getId() == null || memberInfo.getId().trim().isEmpty()) {
			errors.rejectValue("id", "required"); 
			//errors객체에 required(properties에 설정한 값)라는 메세지를 넣는다.?
			//required는 properties에서 작성한 문구인 '필수 항목입니다.' 를 가리킴.
		}
		
		if(memberInfo.getName() == null || memberInfo.getName().trim().isEmpty()) {
			errors.rejectValue("name", "required");
		}
		
		Address address = memberInfo.getAddress();
		
		if(address == null) {
			errors.rejectValue("address", "required");
		}
		
		if(address != null) {
			errors.pushNestedPath("address");
			try {
				
				if(address.getZipcode() == null || address.getZipcode().trim().isEmpty()) {
					errors.rejectValue("zipcode", "required");
				}
				
				if(address.getAddress1() == null || address.getAddress1().trim().isEmpty()) {
					errors.rejectValue("address1", "required");
				}
			} finally {
				errors.popNestedPath();
			}
		}
	}
}

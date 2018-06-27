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
	
	//��ȿ�������� ������ ���������� �ϰ� �ִ�. <->Ŭ���̾�Ʈ���� �ڹٽ�ũ��Ʈ�� �����ϴ¹��??
	@Override
	public void validate(Object target, Errors errors) { //��ȿ���� �����ϴ� validate()�޼���
		MemberInfo memberInfo = (MemberInfo) target;
		if(memberInfo.getId() == null || memberInfo.getId().trim().isEmpty()) {
			errors.rejectValue("id", "required"); 
			//errors��ü�� required(properties�� ������ ��)��� �޼����� �ִ´�.?
			//required�� properties���� �ۼ��� ������ '�ʼ� �׸��Դϴ�.' �� ����Ŵ.
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

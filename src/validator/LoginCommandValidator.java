package validator;

import service.LoginCommand;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

//Validator�������̽��� ������ LoginCommandValidatorŬ����
public class LoginCommandValidator implements Validator { 
	
	@Override 
	//Validator�� �ش� Class�� ���� �� ������ �����ϴ��� ���θ� �����Ѵ�.
	public boolean supports(Class<?> clazz) {
		return LoginCommand.class.isAssignableFrom(clazz);
	}
	
	@Override 
	//target��ü�� ���� ������ �����ϰ�, ������� ������ ���� ������ errors��ü�� � ���������� ���� ������ ����
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
		
		//ValidationUtilsŬ������ rejectIfEmptyOrWhitespace�Լ��� �̿��ؼ� �����Ѵ�.
		//(����� ��� ��ü�ΰ�?,Ȯ���ϰ��� �ϴ� �ʵ��,�����ڵ�)
	}

}

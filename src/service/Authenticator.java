package service;

//Authenticator�̶�� �������̽��� ����. 
public interface Authenticator {
	
	void authenticate(LoginCommand loginCommand) throws AuthenticationException;

}

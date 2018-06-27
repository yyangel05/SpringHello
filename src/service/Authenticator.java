package service;

//Authenticator이라는 인터페이스를 구현. 
public interface Authenticator {
	
	void authenticate(LoginCommand loginCommand) throws AuthenticationException;

}

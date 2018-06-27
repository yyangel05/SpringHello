package service;

import common.CommonLogger;

//Authenticator인터페이스를 구현한 MockAuthenticator
public class MockAuthenticator implements Authenticator {
	private CommonLogger commonLogger;
	
	@Override
	public void authenticate(LoginCommand loginCommand) throws AuthenticationException {
		//아이디와 비밀번호가 서로 동일한 값이 아니라면 log메서드에 인증에러 + 아이디 라는 문구를 집어넣는다?
		if(!loginCommand.getUserId().equals(loginCommand.getPassword())) { //아이디와 비밀번호가 서로 동일한 값이 아니라면
			commonLogger.log("인증 에러 - " + loginCommand.getUserId()); //log메서드에 인증에러 + 아이디 라는 문구를 집어넣는다?
			throw new AuthenticationException(); 
		}
	}
	
	public void setCommonLogger(CommonLogger commonLogger) {
		this.commonLogger = commonLogger;
	}

}
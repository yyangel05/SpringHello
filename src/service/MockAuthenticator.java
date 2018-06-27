package service;

import common.CommonLogger;

//Authenticator�������̽��� ������ MockAuthenticator
public class MockAuthenticator implements Authenticator {
	private CommonLogger commonLogger;
	
	@Override
	public void authenticate(LoginCommand loginCommand) throws AuthenticationException {
		//���̵�� ��й�ȣ�� ���� ������ ���� �ƴ϶�� log�޼��忡 �������� + ���̵� ��� ������ ����ִ´�?
		if(!loginCommand.getUserId().equals(loginCommand.getPassword())) { //���̵�� ��й�ȣ�� ���� ������ ���� �ƴ϶��
			commonLogger.log("���� ���� - " + loginCommand.getUserId()); //log�޼��忡 �������� + ���̵� ��� ������ ����ִ´�?
			throw new AuthenticationException(); 
		}
	}
	
	public void setCommonLogger(CommonLogger commonLogger) {
		this.commonLogger = commonLogger;
	}

}
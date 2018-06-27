package service;

public class LoginCommand {
	
	private String userId; //아이디 변수
	private String password; //비밀번호 변수
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

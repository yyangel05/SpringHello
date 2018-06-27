package common;

//CommonLogger인터페이스를 구현한 CommonLoggerImpl 클래스.
public class CommonLoggerImpl implements CommonLogger {
	
	@Override 
	public void log(String message) {
		System.out.println("CommonLogger - " + message); //메세지의 내용은 id인가?
	}

}

package service;

@SuppressWarnings("serial")
public class AuthenticationException extends Exception {

}

// @SuppressWarnings는 compile시 warnning을 체크하지 않기 위한 용도로 사용된다.
//argument의 "serial"은 java.io.Serializeable 인터페이스를 구현하는데 serialVersionUID 를 정의해 주지 않은 경우
//나타나는 warnning을 체크하지 않겠다는 의미 입니다
//serial 키워드는 직렬화 가능 클래스에 대한 누락된 serialVersionUID필드와 관련된 경고를 억제한다.
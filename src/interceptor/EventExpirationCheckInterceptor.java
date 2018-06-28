package interceptor;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
		
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
		
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class EventExpirationCheckInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if(checkEvent(request)&&checkEventExpiration()) { //요청uri가 list.do이고 이벤트 날짜가 지났다면  
			displayEventExpirationPage(request, response); //이벤트종료.jsp로 리다이렉트하는 메서드로 넘어가게 한다.
			return false;
		}
		return true;
	}
		
	//요청된 url이  SpringHello/event/list.do와 동일한지 검사하여 참/거짓을 리턴하는 메서드
	private boolean checkEvent(HttpServletRequest request) {
		return request.getRequestURI().equals(request.getContextPath() + "/event/list.do");
	}
		
	//오늘날짜와 이벤트 마감날짜를 비교하여 기간이 끝났는지 판별 참/거짓을 리턴
	private boolean checkEventExpiration() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2016, 3, 20); //이벤트 마감날짜지정
		Date now = new Date(); //오늘날짜
		return now.after(calendar.getTime());
	}
		
	private void displayEventExpirationPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("eventExpired.do"); //이벤트가 종료되었다는 jsp로 리다이렉트함.
	}
		
}

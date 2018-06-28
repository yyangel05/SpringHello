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
		if(checkEvent(request)&&checkEventExpiration()) { //��ûuri�� list.do�̰� �̺�Ʈ ��¥�� �����ٸ�  
			displayEventExpirationPage(request, response); //�̺�Ʈ����.jsp�� �����̷�Ʈ�ϴ� �޼���� �Ѿ�� �Ѵ�.
			return false;
		}
		return true;
	}
		
	//��û�� url��  SpringHello/event/list.do�� �������� �˻��Ͽ� ��/������ �����ϴ� �޼���
	private boolean checkEvent(HttpServletRequest request) {
		return request.getRequestURI().equals(request.getContextPath() + "/event/list.do");
	}
		
	//���ó�¥�� �̺�Ʈ ������¥�� ���Ͽ� �Ⱓ�� �������� �Ǻ� ��/������ ����
	private boolean checkEventExpiration() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2016, 3, 20); //�̺�Ʈ ������¥����
		Date now = new Date(); //���ó�¥
		return now.after(calendar.getTime());
	}
		
	private void displayEventExpirationPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("eventExpired.do"); //�̺�Ʈ�� ����Ǿ��ٴ� jsp�� �����̷�Ʈ��.
	}
		
}

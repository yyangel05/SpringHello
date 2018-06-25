package controller;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller   //annotation(=�ּ�). ��Ʈ�������� �׼Ǹ��ΰ� ���� ������ �Ѵ�.
public class HelloController {
	
	@RequestMapping("/hello.do")
	public ModelAndView hello() { 
		ModelAndView mav = new ModelAndView(); //ModelAndView�� ��Ʈ�ѷ��� ó���� ��� ���� �� �� ���ÿ� �ʿ��� ������ ��´�.
		mav.setViewName("hello"); 
		mav.addObject("greeting", getGreeting()); //getGreeting()���� �޾ƿ� ������ greeting�̶�� ������ �ø���.
		return mav;
	}
	
	
	//getGreeting() �Լ��� �ð��뿡 ���� �ٸ� �λ繮���� �����Ѵ�.
	private String getGreeting() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY); //�޷¿��� �ð��� �޾ƿ´�?
		if(hour >= 6 && hour <=10) {
			return "���� ��ħ�Դϴ�.";
		}
		else if(hour >= 12 && hour <=15) {
			return "���� �Ļ�� �߽��ϱ�?";
		}
		else if(hour >= 18 && hour <=22) {
			return "� �ֹ��Լ�";
		}
		return "�ȳ��ϼ���. ����Ʈ ���Դϴ�";	
	}
	
}
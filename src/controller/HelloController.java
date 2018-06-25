package controller;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller   //annotation(=주석). 스트러츠에서 액션매핑과 같은 역할을 한다.
public class HelloController {
	
	@RequestMapping("/hello.do")
	public ModelAndView hello() { 
		ModelAndView mav = new ModelAndView(); //ModelAndView는 컨트롤러가 처리한 결과 정보 및 뷰 선택에 필요한 정보를 담는다.
		mav.setViewName("hello"); 
		mav.addObject("greeting", getGreeting()); //getGreeting()에서 받아온 문구를 greeting이라는 영역에 올린다.
		return mav;
	}
	
	
	//getGreeting() 함수는 시간대에 따라 다른 인사문구를 리턴한다.
	private String getGreeting() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY); //달력에서 시간을 받아온다?
		if(hour >= 6 && hour <=10) {
			return "좋은 아침입니다.";
		}
		else if(hour >= 12 && hour <=15) {
			return "점심 식사는 했습니까?";
		}
		else if(hour >= 18 && hour <=22) {
			return "어서 주무싑쇼";
		}
		return "안녕하세요. 디폴트 값입니다";	
	}
	
}
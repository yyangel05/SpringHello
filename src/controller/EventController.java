package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventController {

	@RequestMapping("/event/list.do") //요청url은 /event/list.do로 설정
	public String list() {
		return "event/list";
	}
	
	@RequestMapping("/event/eventExpired.do") //요청url은 /event/eventExpired.do로 설정
	public String expired() {
		return "event/eventExpired";
	}
}

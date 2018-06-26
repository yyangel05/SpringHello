package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/order/order.do")
public class OrderController {
	
	//겟방식으로 전송되어왔으면 orderForm을 출력한다?
	@RequestMapping(method = RequestMethod.GET) 
	public String form() {
		return "order/orderForm";
	}
	
	
	//포스트방식으로 전송되어왔으면 orderCompletion을 출력한다?
	@RequestMapping(method = RequestMethod.POST) 
	public String submit(OrderCommand orderCommand) { 
		return "order/orderCompletion";
	}

}

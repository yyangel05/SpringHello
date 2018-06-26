package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/order/order.do")
public class OrderController {
	
	//�ٹ������ ���۵Ǿ������ orderForm�� ����Ѵ�?
	@RequestMapping(method = RequestMethod.GET) 
	public String form() {
		return "order/orderForm";
	}
	
	
	//����Ʈ������� ���۵Ǿ������ orderCompletion�� ����Ѵ�?
	@RequestMapping(method = RequestMethod.POST) 
	public String submit(OrderCommand orderCommand) { 
		return "order/orderCompletion";
	}

}

package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {
	
	@RequestMapping("/search/internal.do")
	public ModelAndView searchInternal(@RequestParam("query") String query, // required=true�� �⺻�����̾ query�� null�̸� 400�������
			@RequestParam(value="p", defaultValue="1") int pageNumber) { //p���� null�̸� �ڵ����� 1�� �������ش�
		System.out.println("query=" + query + ",pageNumber=" +pageNumber);
		return new ModelAndView("search/internal");
		
	}
	
	@RequestMapping("/search/external.do")
	public ModelAndView searchExternal(@RequestParam(value="query", required=false) String query, // required=false�� �����ؼ� query�� null�̾ ���ۿ� ����x
			@RequestParam(value="p", defaultValue="1") int pageNumber) { //p���� null�̸� �ڵ����� 1�� �������ش�
		System.out.println("query=" + query + ",pageNumber=" +pageNumber);
		return new ModelAndView("search/external");
	}
	
	
	//requestParam���� �����͸� ���������� ������ 400������ �ߴ� ��� 
	//1.������Ÿ���� ������
	//2.���� ���۵�������(null���� ���۵�)

}

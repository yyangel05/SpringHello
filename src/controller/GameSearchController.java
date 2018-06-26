package controller;

import java.util.ArrayList;
import java.util.List;


import service.SearchCommand;
import service.SearchService;
import service.SearchType;
import service.SearchResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GameSearchController {
	
	@Autowired
	private SearchService searchService;
	
	@ModelAttribute("searchTypeList") //searchTypeList�̸����� ModelAttribute�� ������, jsp���� ���� �� �� �ְ� ��.
	public List<SearchType> referenceSearchTypeList() { 
		//referenceSearchTypeList()�� ���۾��ϴ� �޼��� 
		//@ModelAttribute ������̼��� ���̸� -> ȥ�� �����Ѵ�. �׷��� �� �޼��尡 �����ϴ� ��ü�� �信�� ���� �� �� �ִ� . �� ��ü�� �Ƹ� searchTypeList?
		
		List<SearchType> options = new ArrayList<SearchType>(); //����Ʈ��ü options����.
		options.add(new SearchType(1,"��ü")); //ù��° �� ����
		options.add(new SearchType(2,"������")); //�ι�° �� ����
		options.add(new SearchType(3,"ĳ����")); //����° �� ����
		return options; //options����Ʈ��ü ����.
	}
	
	@ModelAttribute("popularQueryList") //popularQueryList�̸����� ModelAttribute�� ������, jsp���� ���� �� �� �ְ� ��.
	public String[] getPopularQueryList() { 
		return new String[] { "����", "��Ʈ����Ʈ", "��Ʋ�׶���" }; //�迭�� ���� ����
	}
	
	@RequestMapping("/search/main.do")
	public String main() {
		return "search/main";
	}
	
	@RequestMapping("/search/game.do")
	public ModelAndView search(@ModelAttribute("command") SearchCommand command) { //���۵� �����ʹ� �ڹٺ� ����
		ModelAndView mav = new ModelAndView("search/game"); //��������� �����
		System.out.println("�˻��� = " + command.getQuery().toUpperCase()); //���� ȭ�鿡 ���
		SearchResult result = searchService.search(command); //���ϵǴ� ��ü
		mav.addObject("searchResult", result);
		return mav;
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String handleNullPointerException(NullPointerException ex) {
		return "error/nullException";
	}
	
	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}
	

}

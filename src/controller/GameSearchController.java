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
	
	@ModelAttribute("searchTypeList") //searchTypeList이름으로 ModelAttribute를 설정해, jsp에서 갖다 쓸 수 있게 함.
	public List<SearchType> referenceSearchTypeList() { 
		//referenceSearchTypeList()는 동작안하는 메서드 
		//@ModelAttribute 어노테이션을 붙이면 -> 혼자 동작한다. 그래서 이 메서드가 리턴하는 객체를 뷰에서 갖다 쓸 수 있다 . 그 객체는 아마 searchTypeList?
		
		List<SearchType> options = new ArrayList<SearchType>(); //리스트객체 options생성.
		options.add(new SearchType(1,"전체")); //첫번째 값 세팅
		options.add(new SearchType(2,"아이템")); //두번째 값 세팅
		options.add(new SearchType(3,"캐릭터")); //세번째 값 세팅
		return options; //options리스트객체 리턴.
	}
	
	@ModelAttribute("popularQueryList") //popularQueryList이름으로 ModelAttribute를 설정해, jsp에서 갖다 쓸 수 있게 함.
	public String[] getPopularQueryList() { 
		return new String[] { "게임", "포트나이트", "배틀그라운드" }; //배열에 값을 넣음
	}
	
	@RequestMapping("/search/main.do")
	public String main() {
		return "search/main";
	}
	
	@RequestMapping("/search/game.do")
	public ModelAndView search(@ModelAttribute("command") SearchCommand command) { //전송된 데이터는 자바빈에 세팅
		ModelAndView mav = new ModelAndView("search/game"); //포워딩경로 잡아줌
		System.out.println("검색어 = " + command.getQuery().toUpperCase()); //값을 화면에 출력
		SearchResult result = searchService.search(command); //리턴되는 객체
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

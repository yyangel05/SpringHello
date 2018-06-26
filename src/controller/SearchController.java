package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {
	
	@RequestMapping("/search/internal.do")
	public ModelAndView searchInternal(@RequestParam("query") String query, // required=true로 기본설정이어서 query가 null이면 400에러출력
			@RequestParam(value="p", defaultValue="1") int pageNumber) { //p값이 null이면 자동으로 1로 세팅해준다
		System.out.println("query=" + query + ",pageNumber=" +pageNumber);
		return new ModelAndView("search/internal");
		
	}
	
	@RequestMapping("/search/external.do")
	public ModelAndView searchExternal(@RequestParam(value="query", required=false) String query, // required=false로 설정해서 query가 null이어도 동작에 문제x
			@RequestParam(value="p", defaultValue="1") int pageNumber) { //p값이 null이면 자동으로 1로 세팅해준다
		System.out.println("query=" + query + ",pageNumber=" +pageNumber);
		return new ModelAndView("search/external");
	}
	
	
	//requestParam으로 데이터를 개별적으로 받을때 400오류가 뜨는 경우 
	//1.데이터타입의 불일지
	//2.값이 전송되지않음(null값이 전송됨)

}

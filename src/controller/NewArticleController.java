package controller;

import service.ArticleService;
import service.NewArticleCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/article/newArticle.do") //
public class NewArticleController {
	@Autowired
	private ArticleService articleService; //articleService이름을 가진 자바빈 변수.
	
	//get방식일때는 form()이 수행된다. 
	@RequestMapping(method= RequestMethod.GET)
	public String form() {
		return "article/newArticleForm"; //글쓰기 폼이 실행된다.
	}
	
	//post방식일때는 submit()이 수행된다. 
	@RequestMapping(method= RequestMethod.POST)
	public String submit(@ModelAttribute("command") NewArticleCommand command) {  //submit(~~)가 전송된 데이터를 자바빈에 설정한다. //커맨드객체를 초기화하는작업
		// @ModelAttribute("command") 의 ModelAttribute로 커맨드객체의 모델이름을 지정할 수 있다. 안써도 되긴 하지만 이렇게 지정해서 사용할 수 있음.
		articleService.writeArticle(command); //articleService의 writeArticle함수가 실행된다. 
		return "article/newArticleSubmitted"; //글쓰기 처리 후 흘러가는 jsp가 실행된다. 
	}
	
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

}

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
	private ArticleService articleService; //articleService�̸��� ���� �ڹٺ� ����.
	
	//get����϶��� form()�� ����ȴ�. 
	@RequestMapping(method= RequestMethod.GET)
	public String form() {
		return "article/newArticleForm"; //�۾��� ���� ����ȴ�.
	}
	
	//post����϶��� submit()�� ����ȴ�. 
	@RequestMapping(method= RequestMethod.POST)
	public String submit(@ModelAttribute("command") NewArticleCommand command) {  //submit(~~)�� ���۵� �����͸� �ڹٺ� �����Ѵ�. //Ŀ�ǵ尴ü�� �ʱ�ȭ�ϴ��۾�
		// @ModelAttribute("command") �� ModelAttribute�� Ŀ�ǵ尴ü�� ���̸��� ������ �� �ִ�. �Ƚᵵ �Ǳ� ������ �̷��� �����ؼ� ����� �� ����.
		articleService.writeArticle(command); //articleService�� writeArticle�Լ��� ����ȴ�. 
		return "article/newArticleSubmitted"; //�۾��� ó�� �� �귯���� jsp�� ����ȴ�. 
	}
	
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

}

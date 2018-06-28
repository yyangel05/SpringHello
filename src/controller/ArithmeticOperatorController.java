package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ArithmeticOperatorController {
	
	@RequestMapping("/math/add.do")
	public String add(@RequestParam("op1") int op1, @RequestParam("op2") int op2, Model model) {
		model.addAttribute("operation","덧셈"); //result.jsp에서 어떤 연산인지 알려주기 위해 넣은 코드
		model.addAttribute("result", op1+op2); //result에 연산결과를 저장
		return "math/result";
	}

	@RequestMapping("/math/sub.do")
	public String sub(@RequestParam("op1") int op1, @RequestParam("op2") int op2, Model model) {
		model.addAttribute("operation","뺄셈"); //result.jsp에서 어떤 연산인지 알려주기 위해 넣은 코드
		model.addAttribute("result", op1-op2); //result에 연산결과를 저장
		return "math/result";
	}

	@RequestMapping("/math/mul.do")
	public String mul(@RequestParam("op1") int op1, @RequestParam("op2") int op2, Model model) {
		model.addAttribute("operation","곱셈"); //result.jsp에서 어떤 연산인지 알려주기 위해 넣은 코드
		model.addAttribute("result", op1*op2); //result에 연산결과를 저장
		return "math/result";
	}
	
	@RequestMapping("/math/div.do")
	public String div(@RequestParam("op1") int op1, @RequestParam("op2") int op2, Model model) {
		model.addAttribute("operation","나눗셈"); //result.jsp에서 어떤 연산인지 알려주기 위해 넣은 코드
		model.addAttribute("result", op1/op2); //result에 연산결과를 저장
		return "math/result";
	}	
		

}

package controller;

import java.io.File;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class ReportSubmissionController {
	
	private String uploadPath= "C:\\Java\\App\\SpringHello\\WebContent\\file\\"; //���ε� ��� ����.
	
	@RequestMapping(value="/report/submission.do", method= RequestMethod.GET) 
	public String form() {
		return "report/submissionForm";
	}
	
	@RequestMapping(value="/report/submitReport1.do", method= RequestMethod.POST)
	public String submitReport1 (
			@RequestParam("studentNumber") String studentNumber,
			@RequestParam("report") MultipartFile report) {
		printInfo(studentNumber, report);
		
		String fileName= report.getOriginalFilename();
		File uploadFile = new File(uploadPath +fileName);
		//������ �����̸����� �̹� �����Ѵٸ�
		if(uploadFile.exists()) {
			fileName = new Date().getTime() + fileName; //�����̸��� ���ó�¥+�����̸� ���� �ٲ۴�.
			uploadFile = new File(uploadPath + fileName);
		}
		//���ε��ο� ���ε��� ���� �����ϱ� 
		try {
			report.transferTo(uploadFile);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "report/submissionComplete";
	}
			
	private void printInfo(String studentNumber, MultipartFile report) {
		System.out.println(studentNumber + "�� ���ε� �� ����: " + report.getOriginalFilename());
	}
	
	@RequestMapping(value="/report/submitReport2.do", method=RequestMethod.POST)
	public String submitReport2(MultipartHttpServletRequest request) {
		String studentNumber = request.getParameter("studentNumber");
		MultipartFile report = request.getFile("report");
		printInfo(studentNumber, report);
		
		
		String fileName= report.getOriginalFilename();
		File uploadFile = new File(uploadPath +fileName);
		//������ �����̸����� �̹� �����Ѵٸ�
		if(uploadFile.exists()) {
			fileName = new Date().getTime() + fileName; //�����̸��� ���ó�¥+�����̸� ���� �ٲ۴�.
			uploadFile = new File(uploadPath + fileName);
		}
		//���ε��ο� ���ε��� ���� �����ϱ� 
		try {
			report.transferTo(uploadFile);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return "report/submissionComplete";
	}
	
	@RequestMapping(value="/report/submitReport3.do", method=RequestMethod.POST)
	public String submitReport3(ReportCommand reportCommand) {
		printInfo(reportCommand.getStudentNumber(), reportCommand.getReport());
		
		
		String fileName= reportCommand.getReport().getOriginalFilename();
		File uploadFile = new File(uploadPath +fileName);
		//������ �����̸����� �̹� �����Ѵٸ�
		if(uploadFile.exists()) {
			fileName = new Date().getTime() + fileName; //�����̸��� ���ó�¥+�����̸� ���� �ٲ۴�.
			uploadFile = new File(uploadPath + fileName);
		}
		//���ε��ο� ���ε��� ���� �����ϱ� 
		try {
			reportCommand.getReport().transferTo(uploadFile);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return "report/submissionComplete";
	}

}

package controller;

import org.springframework.web.multipart.MultipartFile;

public class ReportCommand {
	
	private String studentNumber; //학번
	private MultipartFile report; //파일
	
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public MultipartFile getReport() {
		return report;
	}
	public void setReport(MultipartFile report) {
		this.report = report;
	}
	
}

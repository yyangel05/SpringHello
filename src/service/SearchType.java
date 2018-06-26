package service;

//자바빈. select박스에 들어갈 항목들을 넣기 위한 상자같음.

public class SearchType {
	
	private int code; //코드값
	private String text; //텍스트창(ex. 전체/아이템/캐릭터)
	
	//SearchType의 생성자.
	public SearchType(int code, String text) {
		this.code = code;
		this.text = text;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	

	
}

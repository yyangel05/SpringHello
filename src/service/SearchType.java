package service;

//�ڹٺ�. select�ڽ��� �� �׸���� �ֱ� ���� ���ڰ���.

public class SearchType {
	
	private int code; //�ڵ尪
	private String text; //�ؽ�Ʈâ(ex. ��ü/������/ĳ����)
	
	//SearchType�� ������.
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

package service;

//�ڹٺ�. �˻��� ���� ���ڰ���

public class SearchCommand {
	
	private String type; //�˻�Ű����Ÿ��
	private String query; //���Ǿ�
	private int page; //?
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}

}

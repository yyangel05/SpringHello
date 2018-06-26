package service;

//자바빈. 검색을 위한 상자같음

public class SearchCommand {
	
	private String type; //검색키워드타입
	private String query; //질의어
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

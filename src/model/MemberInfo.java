package model;

//자바빈

public class MemberInfo {
	
	private String id; //아이디
	private String name; //회원이름
	private Address address; //주소. 타입은 주소빈타입(?).
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}

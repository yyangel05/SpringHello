package model;

public class OrderItem {
	
	private Integer itemId; //상품.. 숫자만 넣을 수 있음
	private Integer number; //개수.. 숫자만 넣을 수 있음.
	private String remark; //주의
	
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	
}

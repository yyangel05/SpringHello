package controller;

import java.util.List;

import model.Address;
import model.OrderItem;

public class OrderCommand {
	
	private List<OrderItem> orderItems; //OrderItem�̶�� �ڹٺ��� ��� ����Ʈ����.
	private Address address; //���ּҴ� �ѹ��� ���� �����ϱ⿡ ����Ʈ�� �ʿ�x
	
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	

}

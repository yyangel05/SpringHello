package controller;

import java.util.List;

import model.Address;
import model.OrderItem;

public class OrderCommand {
	
	private List<OrderItem> orderItems; //OrderItem이라는 자바빈을 담는 리스트변수.
	private Address address; //집주소는 한번만 값을 전송하기에 리스트가 필요x
	
	
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

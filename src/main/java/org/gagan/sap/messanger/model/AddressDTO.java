package org.gagan.sap.messanger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AddressDTO {
	private String address;
	private int pincode;
	
	public AddressDTO(){
		
	}
	public AddressDTO(String address, int pincode) {
		super();
		this.address = address;
		this.pincode = pincode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
}

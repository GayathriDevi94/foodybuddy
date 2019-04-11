package com.foodybuddy.EcomBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Address {
	@ManyToOne
	Customer customer;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addressid;
	@Column(nullable = false)
	private String cusname;

	@Column(nullable = false)
	@NotEmpty(message = "Address Line1 is mandatory")
	private String line1;

	@Column(nullable = false, columnDefinition = "text")
	@NotEmpty(message = "Address Line2 is mandatory")
	private String line2;

	@Column(nullable = false, columnDefinition = "text")
	@NotEmpty(message = "Customer city is mandatory")
	private String city;

	@Column(nullable = false, columnDefinition = "text")
	@NotEmpty(message = "Customer state is mandatory")
	private String state;

	@Column(nullable = false)
	private int pincode;


	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public String getCusname() {
		return cusname;
	}

	public void setCusname(String cusname) {
		this.cusname = cusname;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}



}

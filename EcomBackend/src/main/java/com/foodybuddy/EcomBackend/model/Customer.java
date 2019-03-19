package com.foodybuddy.EcomBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int custid;
	
	@Column(nullable=false)
	private String custname;
	
	@Column(nullable=false,unique=true)
	private String custemailid;
	
	@Column(nullable=false,unique=true)
	private String custphonenumber;
	
	@Transient
	private String custpass;

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getCustemailid() {
		return custemailid;
	}

	public void setCustemailid(String custemailid) {
		this.custemailid = custemailid;
	}

	public String getCustphonenumber() {
		return custphonenumber;
	}

	public void setCustphonenumber(String custphonenumber) {
		this.custphonenumber = custphonenumber;
	}

	public String getCustpass() {
		return custpass;
	}

	public void setCustpass(String custpass) {
		this.custpass = custpass;
	}

		
}

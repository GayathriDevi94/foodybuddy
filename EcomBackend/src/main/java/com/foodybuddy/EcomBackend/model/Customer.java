package com.foodybuddy.EcomBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int custid;

	@Column(nullable = false)
	@NotEmpty(message = "Product name is mandatory")
	@Pattern(regexp = "[a-zA-Z0-9 ]{3,255}", message = "can contain only alphabets max 255 char")
	private String custname;

	@Column(nullable = false, unique = true)
	@Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$", message = "can contan only alphabets manditatory")
	private String custemailid;

	@Column(nullable = false, unique = true)
	@Pattern(regexp = "^([9]{1})([234789]{1})([0-9]{8})$", message = "Mobile number should not exceed 10 digits")
	private String custphonenumber;

	@Transient
	//@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,8}$", message = "Password matching expression. Password must be at least 4 characters, no more than 8 characters, and must include at least one upper case letter, one lower case letter, and one numeric digit.")
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

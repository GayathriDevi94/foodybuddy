package com.foodybuddy.EcomBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int categid;
	
	@Column(nullable=false,unique=true)
	@NotEmpty(message="Category name is mandatory")
	@Pattern(regexp="[a-zA-Z ]{3,255}",message="can contain only alphabets max 255 char")
	private String categname;
	
	@Column(nullable=false)
	@NotEmpty(message="Category description is mandatory")
	@Pattern(regexp="[0-9a-zA-Z ]{3,255}",message="can contain only alphabets and numbers max 255 char")
	private String categdesc;

	public int getCategid() {
		return categid;
	}

	public void setCategid(int categid) {
		this.categid = categid;
	}

	public String getCategname() {
		return categname;
	}

	public void setCategname(String categname) {
		this.categname = categname;
	}

	public String getCategdesc() {
		return categdesc;
	}

	public void setCategdesc(String categdesc) {
		this.categdesc = categdesc;
	}
	

}

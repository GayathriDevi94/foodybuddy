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
public class Seller {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sellerid;
	
	@Column(nullable=false,unique=true)
	@NotEmpty(message="Seller name is mandatory")
	@Pattern(regexp="[a-zA-Z ]{3,255}",message="can contain only alphabets max 255 char")
	private String sellername;
	
	@Column(nullable=false)
	@NotEmpty(message="Seller description is mandatory")
	@Pattern(regexp="[0-9a-zA-Z ]{3,500}",message="can contain only alphabets and numbers max 255 char")
	private String sellerdesc;

	public int getSellerid() {
		return sellerid;
	}

	public void setSellerid(int sellerid) {
		this.sellerid = sellerid;
	}

	public String getSellername() {
		return sellername;
	}

	public void setSellername(String sellername) {
		this.sellername = sellername;
	}

	public String getSellerdesc() {
		return sellerdesc;
	}

	public void setSellerdesc(String sellerdesc) {
		this.sellerdesc = sellerdesc;
	}


	

}

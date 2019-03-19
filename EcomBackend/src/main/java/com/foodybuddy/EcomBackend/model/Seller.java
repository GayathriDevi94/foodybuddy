package com.foodybuddy.EcomBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
@Entity
public class Seller {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sellerid;
	
	@Column(nullable=false,unique=false)
	private String sellername;
	
	@Column(nullable=false)
	private String sellerdesc;

	@Transient
	private String sellerpass;
	
	public String getSellerpass() {
		return sellerpass;
	}

	public void setSellerpass(String sellerpass) {
		this.sellerpass = sellerpass;
	}

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

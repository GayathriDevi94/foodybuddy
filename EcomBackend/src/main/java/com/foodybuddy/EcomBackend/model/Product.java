package com.foodybuddy.EcomBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int prodid;
	
	@Column(nullable=false)
	private String prodname;
	
	@Column(nullable=false)
	private String proddesc;
	
	@ManyToOne
	private Category prodcateg;
	
	@Column(nullable=false)
	private int prodstock;
	
	@Column(nullable=false)
	private int prodprice;

	public int getProdid() {
		return prodid;
	}

	public void setProdid(int prodid) {
		this.prodid = prodid;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public String getProddesc() {
		return proddesc;
	}

	public void setProddesc(String proddesc) {
		this.proddesc = proddesc;
	}

	public Category getProdcateg() {
		return prodcateg;
	}

	public void setProdcateg(Category prodcateg) {
		this.prodcateg = prodcateg;
	}

	public int getProdstock() {
		return prodstock;
	}

	public void setProdstock(int prodstock) {
		this.prodstock = prodstock;
	}

	public int getProdprice() {
		return prodprice;
	}

	public void setProdprice(int prodprice) {
		this.prodprice = prodprice;
	}
	
	

}

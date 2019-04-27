package com.foodybuddy.EcomBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int prodid;
	
	@Column(nullable=false)
	@NotEmpty(message="Product name is mandatory")
	@Pattern(regexp="[a-zA-Z0-9 ]{3,255}",message="can contain only alphabets max 255 char")
	private String prodname;
	
	@Column(nullable=false, columnDefinition="text")
	@NotEmpty(message="Product description is mandatory")
	private String proddesc;
	
	
	@Transient
	MultipartFile pimage;
	
	@ManyToOne
	private Category prodcateg;
	
	
	public Seller getProdsell() {
		return prodsell;
	}

	public void setProdsell(Seller prodsell) {
		this.prodsell = prodsell;
	}

	public MultipartFile getPimage() {
		return pimage;
	}

	public void setPimage(MultipartFile pimage) {
		this.pimage = pimage;
	}

	@ManyToOne
	private Seller prodsell;
	
	@Column(nullable=false)
	@Min(value=0)
	@Max(value=1000)
	private int prodstock;
	
	@Column(nullable=false)
	@Min(value=100)
	@Max(value=1000)
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

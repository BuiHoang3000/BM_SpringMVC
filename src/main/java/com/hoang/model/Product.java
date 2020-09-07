package com.hoang.model;

public class Product {
	private String	pr_ID;
	private String	pr_CA;
	private String	pr_Name;
	private float	pr_Price;
	private int		pr_Quantify;
	private String	pr_SU;
	private String	pr_Status;
	
	public Product(){
		super();
	}
	
	public Product(String pr_ID, String pr_CA, String pr_Name, float pr_Price, int pr_Quantify, String pr_SU, String pr_Status){
		this.pr_ID = pr_ID;
		this.pr_CA = pr_CA;
		this.pr_Name = pr_Name;
		this.pr_Price = pr_Price;
		this.pr_Quantify = pr_Quantify;
		this.pr_SU = pr_SU;
		this.pr_Status = pr_Status;
	}

	public String getPr_ID() {
		return this.pr_ID;
	}

	public void setPr_ID(String pr_ID) {
		this.pr_ID = pr_ID;
	}
	
	public String getPr_CA() {
		return this.pr_CA;
	}
	
	public void setPr_CA(String pr_CA) {
		this.pr_CA = pr_CA;
	}
	
	public String getPr_Name() {
		return this.pr_Name;
	}
	
	public void setPr_Name(String pr_Name) {
		this.pr_Name = pr_Name;
	}
	
	public float getPr_Price() {
		return this.pr_Price;
	}
	
	public void setPr_Price(float pr_Price) {
		this.pr_Price = pr_Price;
	}
	
	public int getPr_Quantify() {
		return this.pr_Quantify;
	}
	
	public void setPr_Quantify(int pr_Quantify) {
		this.pr_Quantify = pr_Quantify;
	}
	
	public String getPr_SU() {
		return this.pr_SU;
	}
	
	public void setPr_SU(String pr_SU) {
		this.pr_SU = pr_SU;
	}
	
	public String getPr_Status() {
		return this.pr_Status;
	}
	
	public void setPr_Status(String pr_Status) {
		this.pr_Status = pr_Status;
	}
}
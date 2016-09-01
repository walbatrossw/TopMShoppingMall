package com.topshop.dto;

public class Product {
	private String pCode = null;
	private String pCate = null;
	private String pName = null;
	private int pPrice = 0;
	private int pCount = 0;
	private String pDate = null;
	private String pDetail = null;
	private String mId = null;
	
	public String getpCode() {
		return pCode;
	}
	public Product setpCode(String pCode) {
		this.pCode = pCode;
		return this;
	}
	public int getpPrice() {
		return pPrice;
	}
	public Product setpPrice(int pPrice) {
		this.pPrice = pPrice;
		return this;
	}
	public String getpCate() {
		return pCate;
	}
	public Product setpCate(String pCate) {
		this.pCate = pCate;
		return this;
	}
	public String getpName() {
		return pName;
	}
	public Product setpName(String pName) {
		this.pName = pName;
		return this;
	}
	public int getpCount() {
		return pCount;
	}
	public Product setpCount(int pCount) {
		this.pCount = pCount;
		return this;
	}
	public String getpDate() {
		return pDate;
	}
	public Product setpDate(String pDate) {
		this.pDate = pDate;
		return this;
	}
	public String getpDetail() {
		return pDetail;
	}
	public Product setpDetail(String pDetail) {
		this.pDetail = pDetail;
		return this;
	}
	public String getmId() {
		return mId;
	}
	public Product setmId(String mId) {
		this.mId = mId;
		return this;
	}
	
}

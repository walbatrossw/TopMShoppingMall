package com.topshop.dto;
//------------------------------------------------------------
//						장바구니 VO
//------------------------------------------------------------
public class Bucket {
	private String bCode = null;
	private String pCode = null;
	private String pName = null;
	private int pPrice = 0;
	private String mId = null;
	
	public String getbCode() {
		return bCode;
	}
	public Bucket setbCode(String bCode) {
		this.bCode = bCode;
		return this;
	}
	public String getpCode() {
		return pCode;
	}
	public Bucket setpCode(String pCode) {
		this.pCode = pCode;
		return this;
	}
	public String getpName() {
		return pName;
	}
	public Bucket setpName(String pName) {
		this.pName = pName;
		return this;
	}
	public int getpPrice() {
		return pPrice;
	}
	public Bucket setpPrice(int pPrice) {
		this.pPrice = pPrice;
		return this;
	}
	public String getmId() {
		return mId;
	}
	public Bucket setmId(String mId) {
		this.mId = mId;
		return this;
	}
	
	
}

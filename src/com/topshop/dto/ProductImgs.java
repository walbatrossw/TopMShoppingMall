package com.topshop.dto;

public class ProductImgs {
	
	int imageCode;
	int pCode;
	String imageName;
	String imageExt;
	long imageSize;
	String imageType;
	public int getImageCode() {
		return imageCode;
	}
	public void setImageCode(int imageCode) {
		this.imageCode = imageCode;
	}
	public int getpCode() {
		return pCode;
	}
	public void setpCode(int pCode) {
		this.pCode = pCode;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImageExt() {
		return imageExt;
	}
	public void setImageExt(String imageExt) {
		this.imageExt = imageExt;
	}
	public long getImageSize() {
		return imageSize;
	}
	public void setImageSize(long imageSize) {
		this.imageSize = imageSize;
	}
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	@Override
	public String toString() {
		return "ProductImgs [imageCode=" + imageCode + ", pCode=" + pCode + ", imageName=" + imageName + ", imageExt="
				+ imageExt + ", imageSize=" + imageSize + ", imageType=" + imageType +  "]";
	}
	

}

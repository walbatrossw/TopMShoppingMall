package com.topshop.forward;

public class MemberForward {
	//������ �Ұ��ΰ�? �����̷�Ʈ �Ұ��ΰ�? ���� 1��
	//��� ���� 1��
	private boolean isRedirect = false;
	private String path = null;
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	@Override
	public String toString() {
		return "MActionForward [isRedirect=" + isRedirect + ", path=" + path + "]";
	}
}

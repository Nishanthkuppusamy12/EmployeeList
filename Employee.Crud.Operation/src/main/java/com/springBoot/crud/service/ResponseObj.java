package com.springBoot.crud.service;

public class ResponseObj {

	private int statusCode;
	private String returnStatus;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getReturnStatus() {
		return returnStatus;
	}
	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}
	public ResponseObj(int statusCode, String returnStatus) {
		super();
		this.statusCode = statusCode;
		this.returnStatus = returnStatus;
	}
	@Override
	public String toString() {
		return "ResponseObj [statusCode=" + statusCode + ", returnStatus=" + returnStatus + "]";
	}
	
	
}

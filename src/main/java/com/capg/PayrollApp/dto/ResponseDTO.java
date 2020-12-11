package com.capg.PayrollApp.dto;

public class ResponseDTO {
	private String message;
	private Object data;
	
	public ResponseDTO(String message,Object data) {
		this.message = message;
		this.data = data;
	}
	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message=message;
	}
	public Object getData() {
		return this.data;
	}
	public void setData(Object data) {
		this.data=data;
	}
}

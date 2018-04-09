package com.yto.pac.http;

public class ResponseData {
	private Boolean success;
	private String errorCode;
	private String errorMsg;
	private Boolean retryLater;
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Boolean getRetryLater() {
		return retryLater;
	}
	public void setRetryLater(Boolean retryLater) {
		this.retryLater = retryLater;
	}
	public ResponseData(Boolean success) {
		super();
		this.success = success;
	}
	public ResponseData() {
	}
	
}

package com.smartship.mds.keyclock.advice;

import static com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(Include.NON_NULL)
public class ErrorResponse {
	
	private String errorCode;
	
	private int status;

	public ErrorResponse(String errorCode, int status) {
		super();
		this.errorCode = errorCode;
		this.status = status;
	}

	public ErrorResponse() {
		
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}

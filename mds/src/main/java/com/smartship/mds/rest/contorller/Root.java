package com.smartship.mds.rest.contorller;

import java.util.List;

import lombok.Data;

@Data
public class Root{
    public String status;
    public List<Data1> data;
    public String message;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Data1> getData() {
		return data;
	}
	public void setData(List<Data1> data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Root [status=" + status + ", data=" + data + ", message=" + message + "]";
	}
    
    
}

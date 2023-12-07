package com.springboot.main.Exception;

public class exceptionModel {
	int status;
	String massage;
	long timestamp;

	public exceptionModel(int status, String massage, long timstamp) {
		this.status = status;
		this.massage = massage;
		this.timestamp = timstamp;
	}

	public exceptionModel() {

	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

}

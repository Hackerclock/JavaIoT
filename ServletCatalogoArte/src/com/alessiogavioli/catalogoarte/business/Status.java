package com.alessiogavioli.catalogoarte.business;

public class Status {
	
	private String status;

	public Status() {
	}

	public Status(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Status: " + status + "\n";
	}

}
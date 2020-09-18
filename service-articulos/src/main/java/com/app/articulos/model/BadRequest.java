package com.app.articulos.model;

import java.io.Serializable;

public class BadRequest implements Serializable {

	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = 6565446547866294916L;

	private String message;
	private int status;

	public BadRequest() {

	}

	public BadRequest(String message, int status) {
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}

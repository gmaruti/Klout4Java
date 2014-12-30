package com.klout4java;

public class Klout4JavaException extends Exception {

	private boolean rateLimitError;
	
	public boolean isRateLimitError() {
		return rateLimitError;
	}

	public void setRateLimitError(boolean rateLimitError) {
		this.rateLimitError = rateLimitError;
	}

	public Klout4JavaException(String message, Throwable t){
		super(message, t);
	}

	public Klout4JavaException(String message){
		super(message);
	}
	
	public Klout4JavaException(String message, int errorCode){
		super(message);
		if (errorCode == 403)
			setRateLimitError(true);
	}
}

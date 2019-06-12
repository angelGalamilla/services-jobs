package com.banorte.xxi.jobServices.commons;

import java.util.ResourceBundle;

public class Messages {

	private static ResourceBundle rb = ResourceBundle.getBundle("com.banorte.xxi.jobServices.messages.messages");
	private static final String BASE_ERROR_PROPERTY = "messages.jobServices.%s";
	
	public static String getMessages(int code) {
		String message = "";
		try {
			String key = String.format(BASE_ERROR_PROPERTY, code);
			message = rb.getString(key);
		}catch (Exception e) {
		}
		return message;
	}
}

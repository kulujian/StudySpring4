package com.study.springcore.case02;

public class Color {
	private String code;
	
	public Color() {
		
	}
	
	public Color(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Color [code=" + code + "]";
	}
	
	
}

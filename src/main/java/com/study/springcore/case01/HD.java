package com.study.springcore.case01;

public class HD {
	private Integer gb;
	
	public HD() {
		
	}
	
	public HD(Integer gb) {
		this.gb = gb;
	}

	public Integer getGb() {
		return gb;
	}

	public void setGb(Integer gb) {
		this.gb = gb;
	}

	@Override
	public String toString() {
		return "HD [gb=" + gb + "]";
	}
	
	
}

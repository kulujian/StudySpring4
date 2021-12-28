package com.study.springcore.case02;

public class Paper2 {
	private Color blue;
	private Size b5;
	
	public Color getBlue() {
		return blue;
	}
	public void setBlue(Color blue) {
		this.blue = blue;
	}
	public Size getB5() {
		return b5;
	}
	public void setB5(Size b5) {
		this.b5 = b5;
	}
	
	@Override
	public String toString() {
		return "Paper2 [blue=" + blue + ", b5=" + b5 + "]";
	}
	
	
	
}

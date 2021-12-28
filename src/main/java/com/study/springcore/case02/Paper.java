package com.study.springcore.case02;

public class Paper {
	private Color color;
	private Size size;
	
	public Paper() {}
	
	public Paper(Color color, Size size) {
		this.color = color;
		this.size = size;
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "Paper [color=" + color + ", size=" + size + "]";
	}
	
	
}

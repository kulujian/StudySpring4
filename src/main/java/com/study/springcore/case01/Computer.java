package com.study.springcore.case01;

public class Computer {
	private CPU cpu;
	private RAM ram;
	private HD hd;
	
	public Computer() {
		
	}
	public Computer(CPU cpu, RAM ram, HD hd) {
		this.cpu = cpu;
		this.ram = ram;
		this.hd = hd;
	}
	public CPU getCpu() {
		return cpu;
	}
	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}
	public RAM getRam() {
		return ram;
	}
	public void setRam(RAM ram) {
		this.ram = ram;
	}
	public HD getHd() {
		return hd;
	}
	public void setHd(HD hd) {
		this.hd = hd;
	}
	
	public Double getPrice() {
		return cpu.getGhz() * 8000 + ram.getGb() * 150 + hd.getGb() * 20;
	}
	
	@Override
	public String toString() {
		return "Computer [cpu=" + cpu + ", ram=" + ram + ", hd=" + hd + "] $" + getPrice();
	}
	
}

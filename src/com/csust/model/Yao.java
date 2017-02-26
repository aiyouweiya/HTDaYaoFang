package com.csust.model;

public class Yao {
	private String bianhao;
	private String name;
	private String type;
	private double sellPrice;
	private double pifaPrice;
	private int remainCount;
	

	@Override
	public String toString() {
		return "Yao [bianhao=" + bianhao + ", name=" + name + ", type=" + type
				+ ", sellPrice=" + sellPrice + ", pifaPrice=" + pifaPrice
				+ ", remainCount=" + remainCount + "]";
	}
	public String getBianhao() {
		return bianhao;
	}
	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}
	public double getPifaPrice() {
		return pifaPrice;
	}
	public void setPifaPrice(double pifaPrice) {
		this.pifaPrice = pifaPrice;
	}
	public int getRemainCount() {
		return remainCount;
	}
	public void setRemainCount(int remainCount) {
		this.remainCount = remainCount;
	}
	
	
	
	
}

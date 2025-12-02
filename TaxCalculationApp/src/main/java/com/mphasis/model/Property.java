package com.mphasis.model;

public class Property {

	private int basePrice;
	private int builtUpArea;
	private int ageOfLand;
	private String location;
	private double tax;

	public Property() {
	}

	public Property(int basePrice, int builtUpArea, int ageOfLand, String location, double tax) {
		this.basePrice = basePrice;
		this.builtUpArea = builtUpArea;
		this.ageOfLand = ageOfLand;
		this.location = location;
		this.tax = tax;
	}

	public int getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}

	public int getBuiltUpArea() {
		return builtUpArea;
	}

	public void setBuiltUpArea(int builtUpArea) {
		this.builtUpArea = builtUpArea;
	}

	public int getAgeOfLand() {
		return ageOfLand;
	}

	public void setAgeOfLand(int ageOfLand) {
		this.ageOfLand = ageOfLand;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		return "AddProperty [basePrice=" + basePrice + ", builtUpArea=" + builtUpArea + ", ageOfLand=" + ageOfLand
				+ ", location=" + location + ", tax=" + tax + "]";
	}
}
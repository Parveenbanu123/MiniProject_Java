package com.mphasis.model;

public class Vehicle {

	private String regNo;
	private String brand;
	private int price;
	private int velocity;
	private int seats;
	private int type;
	private double tax;

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		return "AddVehicle [regNo=" + regNo + ", brand=" + brand + ", price=" + price + ", velocity=" + velocity
				+ ", seats=" + seats + ", type=" + type + ", tax=" + tax + "]";
	}

}
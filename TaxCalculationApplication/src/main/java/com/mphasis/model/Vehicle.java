package com.mphasis.model;

public class Vehicle extends Asset{
	private final String registrationNumber;
    private final String brand;
    private final double purchaseCost;
    private final int velocity;
    private final int capacity;
    private final VehicleType type;
    private double tax;

    public Vehicle(String registrationNumber, String brand, double purchaseCost, int velocity, int capacity, VehicleType type) {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.purchaseCost = purchaseCost;
        this.velocity = velocity;
        this.capacity = capacity;
        this.type = type;
    }

    public String getRegistrationNumber() { return registrationNumber; }
    public String getBrand() { return brand; }
    public double getPurchaseCost() { return purchaseCost; }
    public int getVelocity() { return velocity; }
    public int getCapacity() { return capacity; }
    public VehicleType getType() { return type; }

    public double getTax() { return tax; }
    public void setTax(double tax) { this.tax = tax; }
}

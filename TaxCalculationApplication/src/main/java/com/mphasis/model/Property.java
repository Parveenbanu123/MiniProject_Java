package com.mphasis.model;

public class Property extends Asset{
	private final double baseValue;
    private final double builtUpArea;
    private final int age;
    private final boolean inMainCity;
    private double ageFactor;
    private double tax;

    public Property(double baseValue, double builtUpArea, int age, boolean inMainCity) {
        this.baseValue = baseValue;
        this.builtUpArea = builtUpArea;
        this.age = age;
        this.inMainCity = inMainCity;
    }

    public double getBaseValue() { return baseValue; }
    public double getBuiltUpArea() { return builtUpArea; }
    public int getAge() { return age; }
    public boolean isInMainCity() { return inMainCity; }

    public double getAgeFactor() { return ageFactor; }
    public void setAgeFactor(double ageFactor) { this.ageFactor = ageFactor; }

    public double getTax() { return tax; }
    public void setTax(double tax) { this.tax = tax; }

    /**
     * Default age factor calculation (assumption). You can change logic here.
     * ageFactor = max(0.1, 1.0 - 0.01 * age)
     */
    public static double defaultAgeFactor(int age) {
        double factor = 1.0 - age * 0.01;
        return Math.max(0.1, factor);
    }
}

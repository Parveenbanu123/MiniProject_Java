package com.mphasis.service;

import com.mphasis.model.Property;
import com.mphasis.model.Vehicle;
import com.mphasis.model.VehicleType;
import com.mphasis.repository.InMemoryRepository;

public class TaxService {
	private final InMemoryRepository repository;

    public TaxService(InMemoryRepository repository) {
        this.repository = repository;
    }

    /**
     * Calculate and populate the property's tax and age factor.
     * Formula:
     * If in main city: tax = (builtUpArea * ageFactor * baseValue) + (1/2 * builtUpArea)
     * Else: tax = builtUpArea * ageFactor * baseValue
     */
    public void calculatePropertyTax(Property p) {
        double ageFactor = Property.defaultAgeFactor(p.getAge());
        p.setAgeFactor(ageFactor);
        double tax = p.getBuiltUpArea() * ageFactor * p.getBaseValue();
        if (p.isInMainCity()) tax += 0.5 * p.getBuiltUpArea();
        p.setTax(tax);
    }

    /**
     * Vehicle tax formulas:
     * Petrol: velocity + capacity + 10% purchase cost
     * Diesel: velocity + capacity + 11% purchase cost
     * CNG/LPG: velocity + capacity + 12% purchase cost
     */
    public void calculateVehicleTax(Vehicle v) {
        double percent = 0.10;
        if (v.getType() == VehicleType.DIESEL) percent = 0.11;
        else if (v.getType() == VehicleType.CNG_LPG) percent = 0.12;
        double tax = v.getVelocity() + v.getCapacity() + (percent * v.getPurchaseCost());
        v.setTax(tax);
    }
}

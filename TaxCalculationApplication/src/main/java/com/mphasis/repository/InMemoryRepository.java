package com.mphasis.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mphasis.model.Property;
import com.mphasis.model.Vehicle;

public class InMemoryRepository {
	 private final List<Property> properties = new ArrayList<>();
	    private final List<Vehicle> vehicles = new ArrayList<>();
	    private final Set<String> regNumbers = new HashSet<>();

	    public void addProperty(Property p) {
	        properties.add(p);
	    }

	    public void addVehicle(Vehicle v) {
	        vehicles.add(v);
	        regNumbers.add(v.getRegistrationNumber());
	    }

	    public List<Property> getAllProperties() {
	        return Collections.unmodifiableList(properties);
	    }

	    public List<Vehicle> getAllVehicles() {
	        return Collections.unmodifiableList(vehicles);
	    }

	    public boolean isRegistrationPresent(String reg) {
	        return regNumbers.contains(reg);
	    }

	    public void clearAll() {
	        properties.clear();
	        vehicles.clear();
	        regNumbers.clear();
	    }
}

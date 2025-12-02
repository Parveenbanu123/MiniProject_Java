package com.mphasis.exception;

import com.mphasis.model.Property;
import com.mphasis.model.Vehicle;

public class InputExceptionHandle {

	public static boolean property(Property property) {
		if(property.getBasePrice()<=0)return false;
		if(!property.getLocation().equalsIgnoreCase("Y") && !property.getLocation().equalsIgnoreCase("N"))return false;
		if(property.getAgeOfLand()<=0)return false;

		return true;
		
	}
	
	public static boolean vehicle(Vehicle vehicle) {
		if(vehicle.getRegNo().length()<4 || 
			vehicle.getRegNo().length() > 4 || 
				vehicle.getRegNo().equals("0000") || 
				 !vehicle.getRegNo().matches("\\d{4}")) return false;
		
		if(!vehicle.getBrand().matches("^[A-Za-z]+$")) return false;
		if(vehicle.getPrice()> 1000000 || vehicle.getPrice()<50000) return false;
		if(vehicle.getVelocity()<120 || vehicle.getVelocity()>300) return false;
		if(vehicle.getSeats()<2 || vehicle.getSeats()>50) return false;
		if(vehicle.getType()!=1 || vehicle.getType()!=2 || vehicle.getType()!=3)return false;
		
		return true;
	}
}

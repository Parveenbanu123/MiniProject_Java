package com.mphasis.dao;

import java.util.HashMap;
import java.util.Map;
import com.mphasis.model.Vehicle;
import com.mphasis.service.VehicleService;

public class VehicleDAO {

    // In-memory collection
    public static Map<String, Vehicle> map = new HashMap<>();

    // Insert vehicle (auto-increment ID)
    public boolean insertVehicle(Vehicle vehicle) throws Exception {

        //int id = getLastVehicleId() + 1; // generate new ID
        map.put(vehicle.getRegNo(), vehicle); // save in map

        return true;
    }

    // Get highest ID from map
    public Vehicle getLastVehicleId(String regNo) throws Exception {
              return map.get(regNo);
    }

    // Display all vehicles
    public static void viewAllVehicle() {

        VehicleService.displayEqual();
        VehicleService.displayColumn();
        VehicleService.displayEqual();

        for (Map.Entry<String, Vehicle> entry : map.entrySet()) {

            Vehicle v = entry.getValue();

            double tx = v.getTax(); // already stored after calculation
            String formattedTax = String.format("%.2f", tx);

            System.out.printf(
                "%s%-20s%-15s%-15s%-15s%-15s%-15s%-15s%s",
                "|",
                v.getRegNo(),
                v.getBrand(),
                v.getPrice(),
                v.getVelocity(),
                v.getSeats(),
                v.getType() == 1 ? "Petrol" :
                v.getType() == 2 ? "Diesel" : "CNG/LPG",
                formattedTax,
                "|"
            );

            System.out.println();
        }

        VehicleService.displayEqual();
    }



    // Insert calculated tax
    public static boolean insertTax(String regNo, double tax) throws Exception {
        Vehicle v = map.get(regNo);
        if (v == null)
            return false;

        v.setTax(tax);
        return true;
    }

    // Fetch vehicle by ID
    public Vehicle getVehicleById(String regNo) {
        return map.get(regNo);
    }
}


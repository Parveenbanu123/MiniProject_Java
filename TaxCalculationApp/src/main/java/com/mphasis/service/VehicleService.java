package com.mphasis.service;

import com.mphasis.dao.VehicleDAO;
import com.mphasis.model.Vehicle;

public class VehicleService {

    VehicleDAO dao = new VehicleDAO();

    public double calculateTax(String regNo) throws Exception {

        Vehicle vehicle = VehicleDAO.map.get(regNo);

        if (vehicle == null) {
            throw new Exception("Vehicle with regNo " + regNo + " not found!");
        }

        double tax = 0;

        if (vehicle.getType() == 1) {
            tax = vehicle.getVelocity() + vehicle.getSeats() + (vehicle.getPrice() / 10);
        } 
        else if (vehicle.getType() == 2) {
            tax = vehicle.getVelocity() + vehicle.getSeats() + (vehicle.getPrice() / 11);
        } 
        else if (vehicle.getType() == 3) {
            tax = vehicle.getVelocity() + vehicle.getSeats() + (vehicle.getPrice() / 12);
        }

        return tax;
    }


    public static void displayEqual() {
        System.out.print("+");
        for (int i = 0; i < 110; i++) System.out.print("=");
        System.out.println("+");
    }

    public static void displayColumn() {
        System.out.printf("%s%-20s%-15s%-15s%-15s%-15s%-15s%-15s%s",
                "|","REGISTRATION NO.","BRAND","PRICE","MAX VELOCITY",
                "NO. OF SEATS","VEHICLE TYPE","VEHICLE TAX","|");
        System.out.println();
    }
}

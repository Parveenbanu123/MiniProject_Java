package com.mphasis.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.mphasis.model.Property;
import com.mphasis.model.Vehicle;

public class StorageService {
	public void appendProperty(Property p) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("temp_properties.csv", true))) {
            String line = String.join(",",
                    String.valueOf(p.getBaseValue()),
                    String.valueOf(p.getBuiltUpArea()),
                    String.valueOf(p.getAge()),
                    p.isInMainCity() ? "Y" : "N",
                    String.valueOf(p.getAgeFactor()),
                    String.valueOf(p.getTax())
            );
            bw.write(line);
            bw.newLine();
        }
    }

    public void appendVehicle(Vehicle v) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("temp_vehicles.csv", true))) {
            String line = String.join(",",
                    v.getRegistrationNumber(),
                    v.getBrand(),
                    String.valueOf(v.getPurchaseCost()),
                    String.valueOf(v.getVelocity()),
                    String.valueOf(v.getCapacity()),
                    v.getType().name(),
                    String.valueOf(v.getTax())
            );
            bw.write(line);
            bw.newLine();
        }
    }
}

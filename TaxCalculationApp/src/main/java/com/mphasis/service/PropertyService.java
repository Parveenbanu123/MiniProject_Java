package com.mphasis.service;

import com.mphasis.dao.PropertyDAO;
import com.mphasis.model.Property;

public class PropertyService {

    Property property = new Property();
    double tax;

    private PropertyDAO propertyDAO = new PropertyDAO();

    // Calculates tax using collection-based DAO
    public double calculateTax(int propertyId) throws Exception {

        // Fetch the property from the collection
        property = propertyDAO.getPropertyById(propertyId);

        if (property == null) {
            throw new Exception("Property not found for ID: " + propertyId);
        }

        // Apply your existing tax formula
        if (property.getLocation().equals("Y")) {
            tax = (property.getBuiltUpArea() * property.getAgeOfLand() * property.getBasePrice())
                    + (0.5 * property.getBuiltUpArea());
        } else if (property.getLocation().equals("N")) {
            tax = property.getBuiltUpArea() * property.getAgeOfLand() * property.getBasePrice();
        }

        // Store calculated tax back into the DAO (same as original project flow)
        PropertyDAO.insertTax(propertyId, tax);

        return tax;
    }

    // Display formatting (same as original)
    public static void displayEqual() {
        System.out.print("+");
        for (int i = 0; i < 80; i++)
            System.out.print("=");
        System.out.println("+");
    }

    public static void displayColumn() {
        System.out.printf("%s%-5s%-18s%-15s%-15s%-12s%-15s%s",
                "|", "ID", "BASE PRICE", "BUILT-UP AREA", "AGE(YEARS)",
                "IN CITY", "PROPERTY TAX", "|");
        System.out.println();
    }
}

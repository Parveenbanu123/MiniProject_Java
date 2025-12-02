package com.mphasis.dao;

import java.util.HashMap;
import java.util.Map;
import com.mphasis.model.Property;
import com.mphasis.service.PropertyService;

public class PropertyDAO {

    // In-memory storage (map key is the property ID)
    public static Map<Integer, Property> map = new HashMap<>();

    // Insert property (ID is only in the map key)
    public boolean insertProperty(Property property) throws Exception {

        int id = getLastPropertyId() + 1;   // auto-increment logic
        map.put(id, property);              // store in collection

        return true;
    }

    // Return highest property ID
    public int getLastPropertyId() throws Exception {
        if (map.isEmpty())
            return 0;
        return map.keySet().stream().max(Integer::compare).get();
    }

    // Display all stored properties
    public static void viewAllProperty() throws Exception {

        PropertyService.displayEqual();
        PropertyService.displayColumn();
        PropertyService.displayEqual();

        for (Map.Entry<Integer, Property> entry : map.entrySet()) {

            int id = entry.getKey();
            Property p = entry.getValue();
            double tx = p.getTax();
            String formattedTax = String.format("%.2f", tx);

            System.out.printf("%s%-5s%-18s%-15s%-15s%-12s%-15s%s",
                    "|",
                    id,                       // use map key as ID
                    p.getBasePrice(),
                    p.getBuiltUpArea(),
                    p.getAgeOfLand(),
                    p.getLocation(),
                    formattedTax,
                    "|"
            );
            System.out.println();
        }

        PropertyService.displayEqual();
    }

    // Update tax in collection
    public static boolean insertTax(int id, double tax) throws Exception {
        Property p = map.get(id);
        if (p == null)
            return false;

        p.setTax(tax);
        return true;
    }

    // Fetch property by ID
    public Property getPropertyById(int id) {
        return map.get(id);
    }
}


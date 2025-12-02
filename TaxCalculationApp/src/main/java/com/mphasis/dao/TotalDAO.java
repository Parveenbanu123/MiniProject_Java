package com.mphasis.dao;

import java.util.HashMap;
import java.util.Map;

import com.mphasis.model.Total;
import com.mphasis.service.TaxService;


public class TotalDAO {

    // In-memory storage for totaltax table
    private static Map<Integer, Total> totalMap = new HashMap<>();

    // ======== PROPERTY SECTION ========

    public static int getPropertyQuantity() throws Exception {
        return PropertyDAO.map.size();
    }

    public static double getPropertyTax() throws Exception {
        double sum = 0.0;
        for (var entry : PropertyDAO.map.entrySet()) {
            sum += entry.getValue().getTax();
        }
        return sum;
    }

    // ======== VEHICLE SECTION ========

    public static int getVehicleQuantity() throws Exception {
        return VehicleDAO.map.size();
    }

    public static double getVehicleTax() throws Exception {
        double sum = 0.0;
        for (var entry : VehicleDAO.map.entrySet()) {
            sum += entry.getValue().getTax();
        }
        return sum;
    }

    // ======== TOTAL TAX SECTION ========

    public void insertRecords(Total total) throws Exception {

        // Works exactly like your ON DUPLICATE KEY UPDATE
        totalMap.put(total.getId(), total);
    }

    public Total getTotal() throws Exception {

        Total total = new Total();

        int quantity = 0;
        double taxSum = 0.0;

        for (var item : totalMap.values()) {
            quantity += item.getQuantity();
            taxSum += item.getTax();
        }

        total.setQuantity(quantity);
        total.setTax(taxSum);

        return total;
    }

    public void displayRecords(Total total) throws Exception {

        TaxService.displayEqual();
        TaxService.displayColumn();
        TaxService.displayEqual();

        for (var entry : totalMap.entrySet()) {

            Total t = entry.getValue();
            String formattedTax = String.format("%.2f", t.getTax());

            System.out.printf(
                    "%s%-8s%-15s%10s%15s%s",
                    "|",
                    t.getId(),
                    t.getParticular(),
                    t.getQuantity(),
                    formattedTax,
                    "|"
            );
            System.out.println();
        }

        TaxService.displayEqual();
        TaxService.displaytotal(total);
        TaxService.displayEqual();
    }
}


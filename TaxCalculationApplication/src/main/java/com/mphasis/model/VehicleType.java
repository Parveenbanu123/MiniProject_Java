package com.mphasis.model;

public enum VehicleType {
	PETROL(1), DIESEL(2), CNG_LPG(3);

    private final int code;
    VehicleType(int code) { this.code = code; }

    public int getCode() { return code; }

    public static VehicleType fromInt(int i) {
        return switch (i) {
            case 1 -> PETROL;
            case 2 -> DIESEL;
            case 3 -> CNG_LPG;
            default -> throw new IllegalArgumentException("Invalid vehicle type: " + i);
        };
    }
}

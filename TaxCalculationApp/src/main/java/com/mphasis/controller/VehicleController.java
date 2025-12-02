package com.mphasis.controller;

import com.mphasis.dao.VehicleDAO;

import com.mphasis.exception.InputExceptionHandle;
import com.mphasis.Read;
import com.mphasis.model.Vehicle;
import com.mphasis.service.VehicleService;

public class VehicleController {

	Vehicle vehicle = new Vehicle();
	VehicleDAO vehicleDAO = new VehicleDAO();
	VehicleService vehicleService =new VehicleService();
	int n;
	public void addVehicle() throws Exception {
		boolean entry = true;
		while (entry) {
			System.out.println("1.ADD VEHICLE DETAILS...");
			System.out.println("2.CALCULATE VEHICLE DETAILS...");
			System.out.println("3.DISPLAY VEHICLE DETAILS...");
			System.out.println("4.BACK TO MAIN MENU...");
			n = Read.sc.nextInt();
			if (n ==1) {
				boolean result=insertVehicle();
				if (result) {
					System.out.println("One Vehicle Details Inserted successfully...");
				} else {
					System.out.println("You Entered a input in wrong format...");
				}
			} else if (n ==2) {
				Read.sc.nextLine(); 
				System.out.println("ENTER THE REGISTRATION NUMBER TO CALCULATE THE TAX: ");
				String regNo = Read.sc.nextLine();
				double tax = vehicleService.calculateTax(regNo);
				boolean result = VehicleDAO.insertTax(regNo, tax);
				if (result) {
					System.out.println("Tax Calculation is done successfully...");
				} else {
					System.out.println("Something went wrong...");
				}

			} else if(n==3) {
				VehicleDAO.viewAllVehicle();
			}else if(n==4) {
				System.out.println("Returning to Main Menu...............");
				entry = false;
			}else {
				System.out.println("Enter Correct Option...");
			}
		}
	}
	public boolean insertVehicle() throws Exception {

		Vehicle newVehicle = new Vehicle();
		System.out.println("ENTER THE VEHICLE DETAILS...");
		System.out.println("ENTER THE VEHICLE REGISTRATION NUMBER...");
		newVehicle.setRegNo(Read.sc.next());
		Read.sc.nextLine();
		System.out.println("ENTER THE BRAND OF THE VEHICLE...");
		newVehicle.setBrand(Read.sc.next());
		Read.sc.nextLine();
		System.out.println("ENTER THE MAXIMUM VELOCITY OF THE VEHICLE(KMPH)...");
		newVehicle.setVelocity(Read.sc.nextInt());

		System.out.println("ENTER CAPACITY (NUMBER OF SEATS) OF THE VEHICLE...");
		newVehicle.setSeats(Read.sc.nextInt());

		System.out.println(
				"CHOOSE THE TYPE OF THE VEHICLE-- \n 1.PETROL DRIVEN \n 2.DIESEL DRIVEN \n 3.CNG/LPG DRIVEN \n");
		newVehicle.setType(Read.sc.nextInt());

		System.out.println("ENTER THE PURCHASE COST OF THE VEHICLE -");
		newVehicle.setPrice(Read.sc.nextInt());
		
		if(InputExceptionHandle.vehicle(newVehicle)) {
			return vehicleDAO.insertVehicle(newVehicle);
		}
		return false;
		
	}
}
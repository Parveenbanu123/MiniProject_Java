package com.mphasis.controller;

import com.mphasis.dao.PropertyDAO;
import com.mphasis.exception.InputExceptionHandle;
import com.mphasis.Read;
import com.mphasis.model.Property;
import com.mphasis.service.PropertyService;

public class PropertyController {
	Property property = new Property();
	PropertyDAO propertyDAO = new PropertyDAO();
	PropertyService propertyService = new PropertyService();
	int n;

	public void addProperty() throws Exception {
		boolean entry = true;
		while (entry) {
			System.out.println("1.ADD PROPERTY DETAILS...");
			System.out.println("2.CALCULATE PROPERTY DETAILS...");
			System.out.println("3.DISPLAY PROPERTY DETAILS...");
			System.out.println("4.BACK TO MAIN MENU...");
			n = Read.sc.nextInt();
			if (n == 1) {
				boolean result = insertProperty();
				if (result) {
					System.out.println("One Property Details Inserted successfully...");
				} else {
					System.out.println("You Entered a input in Wrong format...");
				}
			} else if (n == 2) {
				System.out.println("ENTER THE PROPERTY ID TO CALCULATE THE TAX: ");
				int propertyId = Read.sc.nextInt();
				double tax = propertyService.calculateTax(propertyId);
				boolean result = PropertyDAO.insertTax(propertyId, tax);
				if (result) {
					System.out.println("Tax Calculation is done successfully...");
				} else {
					System.out.println("Something went wrong...");
				}
			} else if (n == 3) {
				PropertyDAO.viewAllProperty();
			} else if (n == 4) {
				System.out.println("Returning to Main Menu...............");
				entry = false;

			} else {
				System.out.println("Enter Correct Option...");
			}
		}
	}

	public boolean insertProperty() throws Exception {

		Property newproperty = new Property();
		System.out.println("ENTER THE PROPERTY DETAILS...");
		System.out.println("ENTER THE BASE VALUE OF LAND...");
		newproperty.setBasePrice(Read.sc.nextInt());

		System.out.println("ENTER THE BUILD UP AREA OF LAND...");
		newproperty.setBuiltUpArea(Read.sc.nextInt());

		System.out.println("ENTER THE AGE OF LAND IN YEARS");
		newproperty.setAgeOfLand(Read.sc.nextInt());
		Read.sc.nextLine();
		System.out.println("IS THE LAND LOCATED IN CITY ?(Y= YES | N= NO)");
		newproperty.setLocation(Read.sc.nextLine());

		if(InputExceptionHandle.property(newproperty)) {
			return propertyDAO.insertProperty(newproperty);
		}
		return false;
	}
}
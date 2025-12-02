package com.mphasis;

import com.mphasis.controller.LoginController;
import com.mphasis.controller.PropertyController;
import com.mphasis.controller.TotalController;
import com.mphasis.controller.VehicleController;

public class App {
	public static void main(String[] args) {
		LoginController login = new LoginController();
		boolean entry = true;
		while (entry) {
			if (login.validate()) {
				entry=false;
				boolean exit = true;
				while (exit) {
					System.out.println("1.PROPERTY DETAILS...");
					System.out.println("2.VEHICLES DETAILS...");
					System.out.println("3.CALCULATE TAX...");
					System.out.println("4.EXIT...");
					int n = Read.sc.nextInt();
					switch (n) {
					case 1:
						PropertyController pt = new PropertyController();
						try {
							pt.addProperty();
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					case 2:
						VehicleController vh = new VehicleController();
						try {
							vh.addVehicle();
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					case 3:
						TotalController tc = new TotalController();
						try {
							tc.getAll();
							tc.insertAll();
							tc.getTotal();
							tc.displayAll();
						} catch (Exception e) {
							e.printStackTrace();
						}

						break;
					case 4:
						System.out.println("THANK YOU VISIT AGAIN :)");
						exit = false;
						break;
					default:
						System.out.println("---");
					}
				}
			}else {
				System.out.println("Wrong UserName or Password , Enter Correct Username and Password ");
			}

		}

	}
}


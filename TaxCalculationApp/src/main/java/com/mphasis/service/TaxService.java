package com.mphasis.service;

import com.mphasis.model.Total;

public class TaxService {
	
	public static void displayEqual() {
		System.out.print("+");
		for(int i=0;i<48;i++)System.out.print("=");
		System.out.println("+");
	}
	
	public static void displayColumn() {
		System.out.printf("%s%-8s%-15s%10s%15s%s","|","S.ID","PARTICULAR","QUANTITY","TAX","|");
		System.out.println();
	}
	
	public static void displaytotal(Total total) {
		double tx=total.getTax();
		String tax=String.format("%.2f", tx);
		System.out.printf("%s%-8s%-15s%10s%15s%s","|","TOTAL","----------",total.getQuantity(),tax,"|");
		System.out.println();
	}
}

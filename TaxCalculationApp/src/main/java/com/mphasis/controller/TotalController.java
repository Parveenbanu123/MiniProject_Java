package com.mphasis.controller;

import java.util.HashMap;


import java.util.Map;

import com.mphasis.dao.TotalDAO;
import com.mphasis.model.Total;

public class TotalController {

	Total total=new Total();
	Total getTotal=new Total();
	TotalDAO totalDAO=new TotalDAO();
	int quantity;
	double tax;
	Map<Integer,Total> map=new HashMap<>();
	public void getAll() throws Exception {
		Total total1=new Total();
		total1.setQuantity(TotalDAO.getPropertyQuantity());
		total1.setTax(TotalDAO.getPropertyTax());
		total1.setId(1);
		total1.setParticular("PROPERTIES");
		map.put(total1.getId(), total1);
		
		Total total2=new Total();
		total2.setId(2);
		total2.setParticular("VEHICLES");
		total2.setQuantity(TotalDAO.getVehicleQuantity());
		total2.setTax(TotalDAO.getVehicleTax());
		map.put(total2.getId(), total2);
		
	}
	
	public void insertAll() throws Exception {
		for(Map.Entry<Integer, Total> mp:map.entrySet()) {
			Total list=mp.getValue();
			totalDAO.insertRecords(list);
		}
	}
	public void getTotal() throws Exception {
		getTotal = totalDAO.getTotal();
	}
	public void displayAll() throws Exception {
		totalDAO.displayRecords(getTotal);
	}
}

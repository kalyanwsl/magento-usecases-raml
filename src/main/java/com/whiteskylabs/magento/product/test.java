package com.whiteskylabs.magento.product;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.json.simple.JSONObject;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSONObject header = new JSONObject();
		header.put("DateTime", new SimpleDateFormat("yyyyMMdd HH:mm:ss").format(Calendar.getInstance().getTime()) );
		
		JSONObject productResponse = new JSONObject();
		productResponse.put("ResponseCode", "Success");		
		productResponse.put("ResponseDescription", "Product Successfully Created");
		
		JSONObject productInformation = new JSONObject();
		productInformation.put("ProductId", 1);
		
		
		JSONObject parent = new JSONObject();
		parent.put("HeaderInfo", header );
		//parent.put("CreateProductResponse", productResponse );
		parent.put("ProductInformation", productInformation );
		System.out.println( parent );
		
		

	}

}

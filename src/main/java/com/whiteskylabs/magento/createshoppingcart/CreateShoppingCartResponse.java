package com.whiteskylabs.magento.createshoppingcart;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;
import org.mule.transformer.AbstractTransformer;

public class CreateShoppingCartResponse extends AbstractMessageTransformer {

	 @Override
	 public Object transformMessage(MuleMessage message, String outputEncoding)
	   throws TransformerException {
	  // TODO Auto-generated method stub
	  JSONObject header = new JSONObject();
	  header.put("DateTime", new SimpleDateFormat("yyyyMMdd HH:mm:ss").format(Calendar.getInstance().getTime()) );
	  
	  JSONObject productResponse = new JSONObject();
	  productResponse.put("ResponseCode", "Success");  
	  productResponse.put("ResponseDescription", "Shopping cart Successfully Created");
	  
	  JSONObject productInformation = new JSONObject();
	  try {
	   String productId = message.getPayloadAsString();
	   productInformation.put("QuoteId", productId);
	  } catch (Exception e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  }  
	  
	  JSONObject parent = new JSONObject();
	  parent.put("HeaderInfo", header );
	  //parent.put("CreateProductResponse", productResponse );
	  parent.put("Shopping Cart Information", productInformation );
	  System.out.println( parent );
	  
	  return parent;
	 }
}

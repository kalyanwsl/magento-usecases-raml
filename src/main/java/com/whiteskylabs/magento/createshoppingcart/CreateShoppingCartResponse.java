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
	  
	  JSONObject shoppingCartResponse = new JSONObject();
	  shoppingCartResponse.put("ResponseCode", "Success");  
	  shoppingCartResponse.put("ResponseDescription", "Shopping cart Created Successfully");
	  
	  JSONObject shoppingCartInformation = new JSONObject();
	  try {
	   String shoppingCartId = message.getPayloadAsString();
	   shoppingCartInformation.put("QuoteId", shoppingCartId);
	  } catch (Exception e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  }  
	  
	  JSONObject parent = new JSONObject();
	  parent.put("HeaderInfo", header );
	  parent.put("Shopping Cart Information", shoppingCartInformation );
	  System.out.println( parent );
	  
	  return parent;
	 }
}

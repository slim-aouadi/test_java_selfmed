package fr.selfmed.formatters;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

import com.google.gson.Gson;

import fr.selfmed.models.Transaction;

public class JsonFormat {

	public JsonFormat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String formatInputToJson(List<Transaction> transactions) {
		Gson gson = new Gson();
		String json = gson.toJson(transactions);
	  JsonArrayBuilder builder = Json.createArrayBuilder();
	    for (Transaction trans : transactions) {
	    	Date date=trans.getDate();
	        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        String newDateFormat = formatter.format(date);
	        JsonObjectBuilder object = Json.createObjectBuilder();
	        object
    		.add("id",trans.getId())
    		.add("date",newDateFormat);
	        if(trans.getAmount()<0) {
	        	object.add("debit",Math.abs(trans.getAmount()));
	        	object.add("credit",0);
	        }else {
	        	object.add("debit",0);
	        	object.add("credit",trans.getAmount());
	        }	
	        
    		object.add("label",trans.getLabel())
    			  .add("status",trans.getStatus().toString());
	        builder.add(object.build());
	    }
	
	  JsonObjectBuilder succesBuilder = Json.createObjectBuilder();
	  succesBuilder.add("transaction", builder);
		return  succesBuilder.build().toString();
	}

	
}

package fr.selfmed.formatters;

import java.util.List;

import fr.selfmed.models.Transaction;

public class SelfmedFormat {

	public SelfmedFormat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String formatInputToSelfmed(List<Transaction> transactions) {
		String input = transactions.toString();
		String[] liste = input.substring(1, input.length() - 1).split("],"); 
		String output = "";
		for (String element : liste) { 
			String[] spliByLeft = element.split("[\\[\\]]");
			String objectName = spliByLeft[0].toLowerCase().trim();
			String attributes = spliByLeft[1];
			String[] attributeList = attributes.split(","); 
			String resultSingleObject = ""; 
			resultSingleObject = objectName + ":\n"; 
			for (String attribute : attributeList) {
				resultSingleObject += "\t" + attribute.trim().replace("=", ":") + "\n";
			}
			output+=resultSingleObject;
		}
		
		System.out.println(output);

		return output;
	}


	
}

package fr.selfmed.adapters;

import java.time.LocalDate;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DoubleAdapter extends XmlAdapter<String, Double>{

	@Override
	public Double unmarshal(String v) throws Exception {
		return (double) Math.round( Double.parseDouble(v.replace(",", ".")) * 100) / 100; 
	}

	@Override
	public String marshal(Double v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	 


	

  
}
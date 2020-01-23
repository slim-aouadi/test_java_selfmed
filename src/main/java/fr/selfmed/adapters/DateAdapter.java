package fr.selfmed.adapters;

import java.io.Console;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date>{
	 

	@Override
	public Date unmarshal(String v) throws Exception {	

		LocalDate localDate2 = LocalDate.parse(v);
		java.util.Date date = java.sql.Date.valueOf(localDate2);
	    return date ;
	}
	@Override
	public String marshal(Date v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
 
   
}

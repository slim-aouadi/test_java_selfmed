package fr.selfmed.test.controller;

import fr.selfmed.formatters.JsonFormat;
import fr.selfmed.formatters.SelfmedFormat;
import fr.selfmed.models.Root;
import fr.selfmed.models.Transaction;
import fr.selfmed.test.services.ExternalApiSimulatorService;
import fr.selfmed.unmarshalling.*;

import java.io.IOException;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class OutputController {
    private final ExternalApiSimulatorService externalApiSimulatorService;

    @Autowired
    public OutputController(ExternalApiSimulatorService externalApiSimulatorService) {
        this.externalApiSimulatorService = externalApiSimulatorService;
    }
    
	/***
	 * Gets the input from the existing API ("api/input/xml")  and convert it to json format 
	 * @return 
	 * @throws JAXBException 
	 */
    @GetMapping("/api/output/json")
    public String getAsJsonFormat() throws IOException, JAXBException {
    	 String xmlInput = externalApiSimulatorService.callApi("api/input/xml");
    	 String output="";
			UnMarshall unmarshall=new UnMarshall();
			List<Transaction> transactions = unmarshall.unmarshallInput(xmlInput);
			JsonFormat jsonFormatter=new JsonFormat();	
			 output=jsonFormatter.formatInputToJson(transactions);
		return output ;

    }
    
    
    /***
	 * Gets the input from the existing API ("api/input/xml")  and convert it to selfmed custom format 
	 * @return 
	 */
    @GetMapping("/api/output/selfmed")
    public String getAsSelfmedFormat() throws IOException, JAXBException {
    		String xmlInput = externalApiSimulatorService.callApi("/api/input/xml");
    		String output="";
    		UnMarshall unmarshall=new UnMarshall();
			List<Transaction> transactions = unmarshall.unmarshallInput(xmlInput);
			SelfmedFormat selfmedFormatter=new SelfmedFormat();
			output=selfmedFormatter.formatInputToSelfmed(transactions);
        return output;
    }
}
package fr.selfmed.test.services;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.json.XML;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import fr.selfmed.models.Root;
import fr.selfmed.models.Transaction;

@Service
public class ExternalApiSimulatorService {
    public String callApi(String URI) throws IOException {
    	RestTemplate restTemplate = new RestTemplate();
    	String fooResourceUrl= "http://localhost:8080/"+URI;
    	String result = restTemplate.getForObject(fooResourceUrl, String.class);
        
    	String apiResponse = result;
    	return apiResponse;
        
    }
}
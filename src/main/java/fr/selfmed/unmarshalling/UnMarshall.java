package fr.selfmed.unmarshalling;
import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import fr.selfmed.models.*;
public class UnMarshall {

	
	public UnMarshall() {
		super();
	}

	public List<Transaction> unmarshallInput(String xmlInput) throws JAXBException{	
	 	JAXBContext jaxbContext;
	 	jaxbContext = JAXBContext.newInstance(Root.class);
		Unmarshaller jaxbUnmarshaller=jaxbContext.createUnmarshaller();
		StringReader reader = new StringReader(xmlInput);
		Root p=(Root)jaxbUnmarshaller.unmarshal(reader);
		List<Transaction> transactions = p.getTransaction();
		return transactions;
	}
}

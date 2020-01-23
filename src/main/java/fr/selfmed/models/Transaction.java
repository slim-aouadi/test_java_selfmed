package fr.selfmed.models;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import fr.selfmed.adapters.DateAdapter;
import fr.selfmed.adapters.DoubleAdapter;




public class Transaction {

	private int id;
	
	private String label;
	private Double amount;
	private StatusType status;

	private Date date;
	

	public int getId() {
		return id;
	}
	@XmlAttribute(name="id")
	public void setId(int id) {
		this.id = id;
	}
	@XmlJavaTypeAdapter(DateAdapter.class)
	public Date getDate() {
		return date;
	}
	@XmlAttribute(name="date")
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getLabel() {
		return label;
	}
	@XmlElement
	public void setLabel(String label) {
		this.label = label;
	}
	@XmlJavaTypeAdapter(DoubleAdapter.class)
	public Double getAmount() {
		return amount;
	}
	@XmlElement
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public StatusType getStatus() {
		return status;
	}
	@XmlElement
	public void setStatus(StatusType status) {
		this.status = status;
	}
	
	
	public Transaction(int id, String label, Double amount, StatusType status, Date date) {
		super();
		this.id = id;
		this.label = label;
		this.amount = amount;
		this.status = status;
		this.date = date;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", label=" + label + ", amount=" + amount + ", status=" + status + ", date="
				+ date + "]";
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}



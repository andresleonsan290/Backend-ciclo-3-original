package co.usa.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="message")
public class Message implements Serializable{
    //*****ATRIBUTOS*****
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    
    @Column(name = "messageText")
    private String messageText;
    
    
    //***** RELACIONES *****
    //Relación Muchos a uno. Pueden haber muchos mensajes para un Cabin
    @ManyToOne(optional = false)
    @JsonIgnoreProperties(value = {"messages", "reservations"})
	@JoinColumn(name = "cabin_id")
	private Cabin cabin;

    @ManyToOne(optional = false)
    @JsonIgnoreProperties(value = {"messages", "reservations"})
	@JoinColumn(name = "client_id")
	private Client client;

    
    //*****GETTERS Y SETTERS
    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Cabin getCabin() {
        return cabin;
    }

    public void setCabin(Cabin cabin) {
        this.cabin = cabin;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }    
}

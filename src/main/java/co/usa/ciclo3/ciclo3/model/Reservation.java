package co.usa.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservation")
public class Reservation implements Serializable{
    //***** ATRIBUTOS *****
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;

    @Column(name = "startDate")
    private String startDate;

    @Column(name = "devolutionDate")
    private String devolutionDate;
    
    @Column(name = "status")
    private String status;
    
    public Reservation() {
        this.status = "created";
    }
    
    
    //***** RELACIONES *****:
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("reservations")
	@JoinColumn(name = "cabin_id")
	private Cabin cabin;

    @ManyToOne(optional = false)
    @JsonIgnoreProperties(value = {"messages", "reservations"})
	@JoinColumn(name = "client_id")
	private Client client;
    
    //***********************
    @OneToOne(mappedBy = "reservation", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("reservation")
    private Score score;
    
    
    //*****GETTERS Y SETTERS

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(String devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}

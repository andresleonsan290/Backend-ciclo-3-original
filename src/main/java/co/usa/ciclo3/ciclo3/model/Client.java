package co.usa.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client implements Serializable{
    //*****ATRIBUTOS*****
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
    
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "age")
    private Integer age;

    
    //***** RELACIONES *****:
    // Un cliente puede tener muchas Reservation y Message.
    @OneToMany(mappedBy = "client", cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("client")
    private List<Message> messages;

    @OneToMany(mappedBy = "client", cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("client")
    private List<Reservation> reservations;

    
    //*****GETTERS Y SETTERS
    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}

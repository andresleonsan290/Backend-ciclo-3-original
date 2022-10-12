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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cabin")
public class Cabin implements Serializable{
    //*****ATRIBUTOS*****
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "brand")
    private String brand;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "rooms")
    private Integer rooms;
    
    @Column(name = "description")
    private String description;

    
    //***** RELACIONES *****:
    //Varias cabañas pueden tener una categoría en común
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("cabins")
	@JoinColumn(name = "category_id")
	private Category category;
    
    // Una cabaña puede tener muchas Reservation y Messages.
    @OneToMany(mappedBy = "cabin", cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties(value = {"cabin", "client"})
    private List<Message> messages;

    @OneToMany(mappedBy = "cabin", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = {"cabin", "messages"})
    private List<Reservation> reservations;

    
    //*****GETTERS Y SETTERS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

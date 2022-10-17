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
@Table(name="category")
public class Category implements Serializable{
    //*****ATRIBUTOS*****
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    
    //***** RELACIONES *****:
    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("category")
    private List<Cabin> cabins;

    
    //*****GETTERS Y SETTERS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Cabin> getCabins() {
        return cabins;
    }

    public void setCabins(List<Cabin> cabins) {
        this.cabins = cabins;
    }    
}

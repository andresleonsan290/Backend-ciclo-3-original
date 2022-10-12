package co.usa.ciclo3.ciclo3.repositories;

import co.usa.ciclo3.ciclo3.model.Cabin;
import co.usa.ciclo3.ciclo3.repositories.crud.CabinCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CabinRepository {
    
    @Autowired
    private CabinCrudRepository cabinCrudRepository;
    
    //GET
    public List<Cabin> getAllCabins(){
        return (List<Cabin>) cabinCrudRepository.findAll();
    }
    public Optional<Cabin> getCabin(int id){
        return cabinCrudRepository.findById(id);
    }
    
    //POST
    public Cabin saveCabin(Cabin cabin){ 
        if(cabin.getId()==null){
            return cabinCrudRepository.save(cabin);
        }
        else{
            Optional<Cabin> cabinAux = cabinCrudRepository.findById(cabin.getId());
            if (cabinAux.isEmpty()) {
                return cabinCrudRepository.save(cabin);
            }
            else{
                return cabin;
            }
        }
    }
    
    //DELETE
    public void deleteCabin(int id){
        if (!cabinCrudRepository.findById(id).isEmpty()) {
            cabinCrudRepository.deleteById(id);
        }
    }
    
    //PUT
    public void updateCabin(int id, Cabin cabin){
        if(!cabinCrudRepository.findById(id).isEmpty()){
            Cabin cabinDB = cabinCrudRepository.findById(id).get();
            if (cabin.getBrand() != null) {
                cabinDB.setBrand(cabin.getBrand());
            }
            if (cabin.getName() != null) {
                cabinDB.setName(cabin.getName());
            }
            if (cabin.getRooms() != null) {
                cabinDB.setRooms(cabin.getRooms());
            }
            if (cabin.getDescription() != null) {
                cabinDB.setDescription(cabin.getDescription());
            }
            if (cabin.getCategory() != null) {
                cabinDB.setCategory(cabin.getCategory());
            }
            cabinCrudRepository.save(cabinDB);
        }
    }
    
}

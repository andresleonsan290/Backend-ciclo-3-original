package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Cabin;
import co.usa.ciclo3.ciclo3.repositories.CabinRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CabinService {
    
    @Autowired
    private CabinRepository cabinRepository;
    
    //GET
    public List<Cabin> getAllCabins(){
        return cabinRepository.getAllCabins();
    }
    public Optional<Cabin> getCabin(int id){
        return cabinRepository.getCabin(id);
    }
    
    //POST
    public Cabin saveCabin(Cabin cabin){
        return cabinRepository.saveCabin(cabin);
    }
    
    //DELETE
    public void deleteCabin(int id){
        cabinRepository.deleteCabin(id);
    }
    
    //PUT
    public void updateCabin(int id, Cabin cabin){
        cabinRepository.updateCabin(id, cabin);
    }
    
}
package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Admin;
import co.usa.ciclo3.ciclo3.repositories.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepository;
    
    //GET
    public List<Admin> getAllAdmins(){
        return adminRepository.getAllAdmins();
    }
    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }
    
    //POST
    public Admin saveAdmin(Admin admin){
        return adminRepository.saveAdmin(admin);
    }
    
    //DELETE
    public void deleteAdmin(int id){
        adminRepository.deleteAdmin(id);
    }
    
    //PUT
    public void updateAdmin(int id, Admin admin){
        adminRepository.updateAdmin(id, admin);
    }
    
}

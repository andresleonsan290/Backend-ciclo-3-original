package co.usa.ciclo3.ciclo3.controllers;

import co.usa.ciclo3.ciclo3.model.Admin;
import co.usa.ciclo3.ciclo3.service.AdminService;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AdminController {
    
    @Autowired
    private AdminService adminService;
    
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Admin> getAdmins(){
        return adminService.getAllAdmins();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Admin> getAdmin(@PathVariable("id") int id){
        return adminService.getAdmin(id);
    }
    
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin saveAdmin(@RequestBody Admin admin){
        return adminService.saveAdmin(admin);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAdmin(@PathVariable("id") int id){
        adminService.deleteAdmin(id);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateAdmin(@RequestBody Admin admin){
        adminService.updateAdmin(admin.getId(), admin);
    }
    
}

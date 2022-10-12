package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.repositories.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    
    //GET
    public List<Client> getAllClients(){
        return clientRepository.getAllClients();
    }
    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }
    
    //POST
    public Client saveClient(Client client){
        return clientRepository.saveClient(client);
    }
    
    //DELETE
    public void deleteClient(int id){
        clientRepository.deleteClient(id);
    }
    
    //PUT
    public void updateClient(int id, Client client){
        clientRepository.updateClient(id, client);
    }
    
}

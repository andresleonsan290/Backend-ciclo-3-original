package co.usa.ciclo3.ciclo3.repositories;

import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.repositories.crud.ClientCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepository {
    
    @Autowired
    private ClientCrudRepository clientCrudRepository;
    
    //GET
    public List<Client> getAllClients(){
        return (List<Client>) clientCrudRepository.findAll();
    }
    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }
    
    //POST
    public Client saveClient(Client client){ 
        if(client.getIdClient()==null){
            return clientCrudRepository.save(client);
        }
        else{
            Optional<Client> clientAux = clientCrudRepository.findById(client.getIdClient());
            if (clientAux.isEmpty()) {
                return clientCrudRepository.save(client);
            }
            else{
                return client;
            }
        }
    }
    
    //DELETE
    public void deleteClient(int id){
        if (!clientCrudRepository.findById(id).isEmpty()) {
            clientCrudRepository.deleteById(id);
        }
    }
    
    //PUT
    public void updateClient(int id, Client client){
        if(!clientCrudRepository.findById(id).isEmpty()){
            Client clientDB = clientCrudRepository.findById(id).get();
            if (client.getName() != null) {
                clientDB.setName(client.getName());
            }
            if (client.getPassword() != null) {
                clientDB.setPassword(client.getPassword());
            }
            if (client.getAge() != null) {
                clientDB.setAge(client.getAge());
            }
            clientCrudRepository.save(clientDB);
        }
    }
    
}
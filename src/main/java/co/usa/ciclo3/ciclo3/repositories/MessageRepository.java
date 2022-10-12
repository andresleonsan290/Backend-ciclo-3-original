package co.usa.ciclo3.ciclo3.repositories;

import co.usa.ciclo3.ciclo3.model.Message;
import co.usa.ciclo3.ciclo3.repositories.crud.MessageCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessageRepository {
    
    @Autowired
    private MessageCrudRepository messageCrudRepository;
    
    //GET
    public List<Message> getAllMessages(){
        return (List<Message>) messageCrudRepository.findAll();
    }
    public Optional<Message> getMessage(int id){
        return messageCrudRepository.findById(id);
    }
    
    //POST
    public Message saveMessage(Message message){ 
        if(message.getIdMessage()==null){
            return messageCrudRepository.save(message);
        }
        else{
            Optional<Message> messageAux = messageCrudRepository.findById(message.getIdMessage());
            if (messageAux.isEmpty()) {
                return messageCrudRepository.save(message);
            }
            else{
                return message;
            }
        }
    }
    
    //DELETE
    public void deleteMessage(int id){
        if (!messageCrudRepository.findById(id).isEmpty()) {
            messageCrudRepository.deleteById(id);
        }
    }
    
    //PUT
    public void updateMessage(int id, Message message){
        if(!messageCrudRepository.findById(id).isEmpty()){
            Message messageDB = messageCrudRepository.findById(id).get();
            if (message.getMessageText() != null) {
                messageDB.setMessageText(message.getMessageText());
            }
            messageCrudRepository.save(messageDB);
        }
    }
    
}

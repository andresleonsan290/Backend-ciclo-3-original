package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Message;
import co.usa.ciclo3.ciclo3.repositories.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;
    
    //GET
    public List<Message> getAllMessages(){
        return messageRepository.getAllMessages();
    }
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }
    
    //POST
    public Message saveMessage(Message message){
        return messageRepository.saveMessage(message);
    }
    
    //DELETE
    public void deleteMessage(int id){
        messageRepository.deleteMessage(id);
    }
    
    //PUT
    public void updateMessage(int id, Message message){
        messageRepository.updateMessage(id, message);
    }
    
}

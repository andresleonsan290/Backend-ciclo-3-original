package co.usa.ciclo3.ciclo3.controllers;

import co.usa.ciclo3.ciclo3.model.Message;
import co.usa.ciclo3.ciclo3.service.MessageService;

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
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MessageController {
    
    @Autowired
    private MessageService messageService;
    
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Message> getMessages(){
        return messageService.getAllMessages();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Message> getMessage(@PathVariable("id") int id){
        return messageService.getMessage(id);
    }
    
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message saveMessage(@RequestBody Message message){
        return messageService.saveMessage(message);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMessage(@PathVariable("id") int id){
        messageService.deleteMessage(id);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateMessage(@RequestBody Message message){
        messageService.updateMessage(message.getIdMessage(), message);
    }
    
}

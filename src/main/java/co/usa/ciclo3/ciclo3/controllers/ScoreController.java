package co.usa.ciclo3.ciclo3.controllers;

import co.usa.ciclo3.ciclo3.model.Score;
import co.usa.ciclo3.ciclo3.service.ScoreService;

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
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ScoreController {
    
    @Autowired
    private ScoreService scoreService;
    
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Score> getScores(){
        return scoreService.getAllScores();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Score> getScore(@PathVariable("id") int id){
        return scoreService.getScore(id);
    }
    
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score saveScore(@RequestBody Score score){
        return scoreService.saveScore(score);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteScore(@PathVariable("id") int id){
        scoreService.deleteScore(id);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateScore(@RequestBody Score score){
        scoreService.updateScore(score.getIdScore(), score);
    }
    
}

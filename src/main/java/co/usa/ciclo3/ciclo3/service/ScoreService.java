package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Score;
import co.usa.ciclo3.ciclo3.repositories.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    
    @Autowired
    private ScoreRepository scoreRepository;
    
    //GET
    public List<Score> getAllScores(){
        return scoreRepository.getAllScores();
    }
    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }
    
    //POST
    public Score saveScore(Score score){
        return scoreRepository.saveScore(score);
    }
    
    //DELETE
    public void deleteScore(int id){
        scoreRepository.deleteScore(id);
    }
    
    //PUT
    public void updateScore(int id, Score score){
        scoreRepository.updateScore(id, score);
    }
    
}

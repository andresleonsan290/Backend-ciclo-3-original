package co.usa.ciclo3.ciclo3.repositories;

import co.usa.ciclo3.ciclo3.model.Score;
import co.usa.ciclo3.ciclo3.repositories.crud.ScoreCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ScoreRepository {
    
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;
    
    //GET
    public List<Score> getAllScores(){
        return (List<Score>) scoreCrudRepository.findAll();
    }
    public Optional<Score> getScore(int id){
        return scoreCrudRepository.findById(id);
    }
    
    //POST
    public Score saveScore(Score score){ 
        if(score.getIdScore()==null){
            return scoreCrudRepository.save(score);
        }
        else{
            Optional<Score> scoreAux = scoreCrudRepository.findById(score.getIdScore());
            if (scoreAux.isEmpty()) {
                return scoreCrudRepository.save(score);
            }
            else{
                return score;
            }
        }
    }
    
    //DELETE
    public void deleteScore(int id){
        if (!scoreCrudRepository.findById(id).isEmpty()) {
            scoreCrudRepository.deleteById(id);
        }
    }
    
    //PUT
    public void updateScore(int id, Score score){
        if(!scoreCrudRepository.findById(id).isEmpty()){
            Score scoreDB = scoreCrudRepository.findById(id).get();
            if (score.getStars() != null) {
                scoreDB.setStars(score.getStars());
            }
            if (score.getMessageText() != null) {
                scoreDB.setMessageText(score.getMessageText());
            } 
            scoreCrudRepository.save(scoreDB);
        }
    }
    
}

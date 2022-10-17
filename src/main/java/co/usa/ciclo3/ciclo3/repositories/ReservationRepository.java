package co.usa.ciclo3.ciclo3.repositories;

import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.model.custom.CountClient;
import co.usa.ciclo3.ciclo3.repositories.crud.ReservationCrudRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    
    //GET
    public List<Reservation> getAllReservations(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    
    //POST
    public Reservation saveReservation(Reservation reservation){
        //reservation.setStartDate(reservation.getStartDate() + "T00:00:00.000+00:00");
        //reservation.setDevolutionDate(reservation.getDevolutionDate() + "T00:00:00.000+00:00");
        if(reservation.getIdReservation()==null){
            return reservationCrudRepository.save(reservation);
        }
        else{
            Optional<Reservation> reservationAux = reservationCrudRepository.findById(reservation.getIdReservation());
            if (!reservationAux.isPresent()) {
                return reservationCrudRepository.save(reservation);
            }
            else{
                return reservation;
            }
        }
    }
    
    //DELETE
    public void deleteReservation(int id){
        if (reservationCrudRepository.findById(id).isPresent()) {
            reservationCrudRepository.deleteById(id);
        }
    }
    
    //PUT
    public void updateReservation(int id, Reservation reservation){
        if(reservationCrudRepository.findById(id).isPresent()){
            Reservation reservationDB = reservationCrudRepository.findById(id).get();
            if (reservation.getStartDate() != null) {
                reservationDB.setStartDate(reservation.getStartDate());
            }
            if (reservation.getDevolutionDate() != null) {
                reservationDB.setDevolutionDate(reservation.getDevolutionDate());
            }
            if (reservation.getStatus() != null) {
                reservationDB.setStatus(reservation.getStatus());
            }
            reservationCrudRepository.save(reservationDB);
        }
    }
    
    
    public List<Reservation> getReservationsByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }
    
    public List<Reservation> getReservationPeriod(Date dateOne, Date dateTwo){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }
    
    public List<CountClient> getTopClients(){
        List<CountClient> res = new ArrayList<>();
        
        List<Object[]> report = reservationCrudRepository.countTotalReservationByClient();
        for(int i = 0; i < report.size(); i++){
            Client client = (Client) report.get(i)[0];
            long amount = (long) report.get(i)[1];
            CountClient cc = new CountClient(amount, client);
            res.add(cc);
            
            //res.add(new CountClient((Integer) report.get(i)[1], (Client) report.get(i)[0]));
        }
        
                
        return res;
    }
    
}

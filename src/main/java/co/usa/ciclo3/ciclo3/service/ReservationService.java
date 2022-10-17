package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.model.custom.CountClient;
import co.usa.ciclo3.ciclo3.model.custom.StatusAmount;
import co.usa.ciclo3.ciclo3.repositories.ReservationRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    //GET
    public List<Reservation> getAllReservations(){
        return reservationRepository.getAllReservations();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    
    //POST
    public Reservation saveReservation(Reservation reservation){
        return reservationRepository.saveReservation(reservation);
    }
    
    //DELETE
    public void deleteReservation(int id){
        reservationRepository.deleteReservation(id);
    }
    
    //PUT
    public void updateReservation(int id, Reservation reservation){
        reservationRepository.updateReservation(id, reservation);
    }
    
    public List<CountClient> getTopClients(){
        return reservationRepository.getTopClients();
    }
    
    public StatusAmount getStatusReport(){
        List<Reservation> completed = reservationRepository.getReservationsByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationsByStatus("cancelled");
        return new StatusAmount(completed.size(), cancelled.size());
    }
    
    public List<Reservation> getReservationPeriod(String d1, String d2){
        //yyyy-MM-dd
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOne = new Date();
        Date dateTwo = new Date();
        try{
            dateOne = parser.parse(d1);
            dateTwo = parser.parse(d2);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        if (dateOne.before(dateTwo)) {
            return reservationRepository.getReservationPeriod(dateOne, dateTwo);
        }
        else{
            return new ArrayList<>();
        }
        
    }
    
}

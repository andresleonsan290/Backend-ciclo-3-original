package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.repositories.ReservationRepository;
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
    
}

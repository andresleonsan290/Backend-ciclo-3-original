package co.usa.ciclo3.ciclo3.repositories;

import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.repositories.crud.ReservationCrudRepository;
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
        reservation.setStartDate(reservation.getStartDate() + "T00:00:00:000+00:00");
        reservation.setDevolutionDate(reservation.getDevolutionDate() + "T00:00:00:000+00:00");
        if(reservation.getIdReservation()==null){
            return reservationCrudRepository.save(reservation);
        }
        else{
            Optional<Reservation> reservationAux = reservationCrudRepository.findById(reservation.getIdReservation());
            if (reservationAux.isEmpty()) {
                return reservationCrudRepository.save(reservation);
            }
            else{
                return reservation;
            }
        }
    }
    
    //DELETE
    public void deleteReservation(int id){
        if (!reservationCrudRepository.findById(id).isEmpty()) {
            reservationCrudRepository.deleteById(id);
        }
    }
    
    //PUT
    public void updateReservation(int id, Reservation reservation){
        if(!reservationCrudRepository.findById(id).isEmpty()){
            Reservation reservationDB = reservationCrudRepository.findById(id).get();
            if (reservation.getStartDate() != null) {
                reservation.setStartDate(reservation.getStartDate() + "T00:00:00:000+00:00");
                reservationDB.setStartDate(reservation.getStartDate());
            }
            if (reservation.getDevolutionDate() != null) {
                reservation.setDevolutionDate(reservation.getDevolutionDate() + "T00:00:00:000+00:00");
                reservationDB.setDevolutionDate(reservation.getDevolutionDate());
            }
            if (reservation.getStatus() != null) {
                reservationDB.setStatus(reservation.getStatus());
            }
            reservationCrudRepository.save(reservationDB);
        }
    }
    
}

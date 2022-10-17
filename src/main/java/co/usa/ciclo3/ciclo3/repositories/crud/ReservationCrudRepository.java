package co.usa.ciclo3.ciclo3.repositories.crud;

import co.usa.ciclo3.ciclo3.model.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer>{
    
    @Query("select c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) desc")
    public List<Object[]> countTotalReservationByClient();
    
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    
    public List<Reservation> findAllByStatus(String status);
        
}

package tn.esprit.tpfoyer.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.tpfoyer.entity.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation,Long> {
}
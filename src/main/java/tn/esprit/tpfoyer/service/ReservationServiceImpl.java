package tn.esprit.tpreservation.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.repository.ReservationRepository;
import tn.esprit.tpfoyer.service.IReservationService;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService {
    ReservationRepository reservationRepository;
  public List<Reservation> retrieveAllReservations() {

      return (List<Reservation>) reservationRepository.findAll();
    }
  public Reservation retrieveReservation(Long ReservationId) {
      return reservationRepository. findById(ReservationId).get();
  }

 public Reservation addReservation(Reservation c) {
      return reservationRepository.save(c);
 }
 public void removeReservation(Long reservationId) {
     reservationRepository.deleteById (reservationId);
     }
 public Reservation modifyReservation(Reservation reservation) {

     return reservationRepository.save(reservation);

         }



 }



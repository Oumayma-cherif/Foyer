package tn.esprit.tpfoyer.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.repository.ReservationRepository;
import tn.esprit.tpfoyer.service.ReservationService;

import java.util.List;
@RestController
public class ReservationServiceIMP implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getallReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation Reservationbyid(String id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public void deletereservation(String id) {
        reservationRepository.deleteById(id);

    }
}

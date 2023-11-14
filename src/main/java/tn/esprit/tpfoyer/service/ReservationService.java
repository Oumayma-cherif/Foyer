package tn.esprit.tpfoyer.service;

import org.springframework.stereotype.Service;

import tn.esprit.tpfoyer.entity.Reservation;

import java.util.List;

@Service
public interface ReservationService {
    Reservation createReservation(Reservation reservation);

    Reservation updateReservation(Reservation reservation);
    List<Reservation> getallReservations();
    Reservation Reservationbyid(String id);
    void deletereservation(String id);
}

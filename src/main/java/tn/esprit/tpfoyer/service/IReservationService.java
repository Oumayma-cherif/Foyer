package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Reservation;

import java.util.List;

public interface IReservationService {
    public List<Reservation> retrieveAllReservations();
    public Reservation retrieveReservation(Long reservationId);
    public Reservation addReservation(Reservation c);
    public void removeReservation(Long reservationId);
    public Reservation modifyReservation(Reservation reservation);
// Here we will add later methods calling keywords and methods calling JPQL
}

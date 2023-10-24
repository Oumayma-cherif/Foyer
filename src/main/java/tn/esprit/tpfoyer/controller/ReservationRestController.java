package tn.esprit.tpfoyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.service.IReservationService;

import java.util.List;


@Tag(name = "Gestion Reservation")
@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {
    IReservationService reservationService;
    // http://localhost:8089/tpfoyer/reservation/retrieve-all-reservations

    @Operation(description = "récupérer toutes les reservations de la base de données")
    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> getReservations() {
        List<Reservation> listReservations = reservationService. retrieveAllReservations();
        return listReservations;

    }
 //http://localhost:8089/tpfoyer/reservation/retrieve-reservation/8

    @Operation(description = "récupérer les details du  reservation de la base de données")
    @GetMapping("/retrieve-reservation/{reservation-id}")
        public Reservation retrieveReservation(@PathVariable("reservation-id") Long chid) {
            Reservation reservation = reservationService.retrieveReservation (chid);
            return reservation;

    }
    // http://localhost:8089/tpfoyer/reservation/add-reservation

    @Operation(description = "ajouter une  reservation a la base de données")
    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation c) {
        Reservation reservation = reservationService.addReservation(c);
        return reservation;
    }
    // http://localhost:8089/tpfoyer/reservation/remove-reservation/{reservation-id}
    @Operation(description = "supprimer une  reservation de  la base de données")
    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") Long chId) {
        reservationService.removeReservation(chId);
    }
    // http://localhost:8089/tpfoyer/reservation/modify-reservation
    @Operation(description = "modifier une  reservation de  la base de données")
    @PutMapping("/modify-reservation")
    public Reservation modifyReservation(@RequestBody Reservation c) {
        Reservation reservation = reservationService.modifyReservation(c);
        return reservation;
    }
}




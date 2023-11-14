package tn.esprit.tpfoyer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.repository.ReservationRepository;
import tn.esprit.tpfoyer.service.imp.ReservationServiceIMP;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/reservation")
public class ReservationBloc {
    @Autowired
    private ReservationServiceIMP reservationServiceIMP;
    @Autowired
    private ReservationRepository reservationRepository;

    @PostMapping("/save")
    private Reservation saveReservation(Reservation reservation){return reservationServiceIMP.createReservation(reservation);}

    @GetMapping("/all")
    public List<Reservation> getallReservations(){return reservationServiceIMP.getallReservations();}
    @GetMapping("/getone/{id}")
    public Reservation getoneReservation(@PathVariable String id){return reservationServiceIMP.Reservationbyid(id);}

    @PutMapping("/update/{id}")
    public Reservation updatereReservation(@PathVariable String id,@RequestBody Reservation reservation){
        Reservation r=reservationServiceIMP.Reservationbyid(id);
        if (r !=null){
            reservation.setIdReservation(id);
            return reservationServiceIMP.updateReservation(reservation);
        }else{
            throw new RuntimeException("ID not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String,String> deleteetudiant(@PathVariable String id){
        HashMap message =new HashMap();
        try{
            Optional<Reservation> e=reservationRepository.findById(id);
            if (e.isPresent()){
                reservationServiceIMP.deletereservation(id);
                message.put("etat","Etudiant deleted");
            }else {
                message.put("etat","ID not found");
            }
        }catch (Exception e){
            message.put("etat","error");
        }
        return message;
    }
}

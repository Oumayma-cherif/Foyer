package tn.esprit.tpfoyer.entity;


import jakarta.persistence.* ;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Reservation {
    @Id
    @GeneratedValue
    @Column (name = "idReservation" , nullable = false)
    private String idReservation ;
    private Boolean estValide ;
    private Date anneeUniversitaire ;

}
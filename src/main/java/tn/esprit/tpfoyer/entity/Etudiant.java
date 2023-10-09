package tn.esprit.tpfoyer.entity;


import jakarta.persistence.* ;
import lombok.*;

import java.util.Set;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant ;
    private String nomET ;
    private String prenomEt ;
    private Long cin ;
    private String ecole ;
    private Date  dateNaissance ;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set <Reservation> reservations;



}

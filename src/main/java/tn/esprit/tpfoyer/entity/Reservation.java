package tn.esprit.tpfoyer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Reservation")
public class Reservation implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String IdReservation;
    private Date AnneeUniversitaire;
    private boolean estValide;


    @ManyToMany(mappedBy = "reservations",cascade = CascadeType.ALL)
    private Collection<Etudiant> etudiants ;

}

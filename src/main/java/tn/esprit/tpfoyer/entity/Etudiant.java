package tn.esprit.tpfoyer.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.Date;
@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Etudiant")
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdEtudiant;
    private String NomEt;
    private String PrenomEt;
    private Long Cin;
    private String Ecole;
    private Date datedenaissance;


    @ManyToMany
    @JoinTable(name = "ID_res-ID_etud" , joinColumns = @JoinColumn(name = "ID_etud"),
            inverseJoinColumns = @JoinColumn(name = "ID_res"))
    private Collection<Reservation> reservations;


}

package tn.esprit.tpfoyer.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Foyer")
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdFoyer;

    private String nomFoyer;
    private Long capaciteFoyer;

    /*--------------------------------------------*/
    @OneToMany(mappedBy = "foyer" , cascade = CascadeType.ALL)
    private Collection<Bloc> blocs;
    /*--------------------------------------------*/

    @OneToOne
    private Universite universite;



}

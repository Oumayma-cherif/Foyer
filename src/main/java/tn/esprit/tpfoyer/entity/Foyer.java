package tn.esprit.tpfoyer.entity;

import jakarta.persistence.* ;
import lombok.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer ;
    private String nomFoyer ;
    private Long capaciteFoyer ;

    @OneToOne(mappedBy= "foyer")

    private Universite universite;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="foyer")
    private Set<Bloc> Bloc;

}

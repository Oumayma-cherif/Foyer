package tn.esprit.tpfoyer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.* ;
import lombok.*;
import lombok.ToString.Exclude;

import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc ;
    private String nomBloc ;
    private Long capaciteBloc ;


    @OneToMany(cascade = CascadeType.ALL, mappedBy="bloc")
    private Set<Chambre> Chambres;

    @ManyToOne
    Foyer foyer ;
}

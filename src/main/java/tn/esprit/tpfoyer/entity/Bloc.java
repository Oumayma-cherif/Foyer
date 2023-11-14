package tn.esprit.tpfoyer.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Collection;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Bloc")
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdBloc;
    private String NomBloc;
    private Long CapaciteBloc;

    /*-----------------------------------*/
    @ManyToOne
    @JoinColumn(name="foyer_id")
    private Foyer foyer;
    /*------------------------------*/

    @OneToMany (mappedBy = "bloc" , cascade = CascadeType.ALL)
    @ToString.Exclude
    private Collection<Chamber> chambers;
    /*-----------------------*/



}

package tn.esprit.tpfoyer.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collection;

@Entity

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
    private Collection<Chamber> chambers;
    /*-----------------------*/



}

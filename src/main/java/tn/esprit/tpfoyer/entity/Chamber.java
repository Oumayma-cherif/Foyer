package tn.esprit.tpfoyer.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name="Chamber")
public class Chamber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdChamber;

    private Long numeroChamber;

    @Enumerated(EnumType.STRING)
    private TypeChamber typec;


    @ManyToOne
    @JoinColumn(name = "Bloc_id")
    private Bloc bloc;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Reservation> reservations;


}

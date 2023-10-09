package tn.esprit.tpfoyer.entity;
import java.util.Set;
import jakarta.persistence.* ;
import lombok.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre ;
    private Long numeroChambre;
    @Enumerated (EnumType.STRING)
    private TypeChambre typeC ;


    @ManyToOne
   Bloc bloc ;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Reservation> Reservations;

}

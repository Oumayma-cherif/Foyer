package tn.esprit.tpfoyer.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.tpfoyer.entity.Foyer;

import java.util.List;

public interface FoyerRepository  extends CrudRepository<Foyer,Long> {

    List<Foyer> findByNomFoyer(String nom);

    List<Foyer> getFoyerByCapaciteFoyerBetweenAndNomFoyer(long val1, long val2, String nom);

    /*@Query("select f. from Foyer f")
    List<Foyer> retrieveAll();*/
}
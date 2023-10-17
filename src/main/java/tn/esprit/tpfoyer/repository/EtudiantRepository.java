package tn.esprit.tpfoyer.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.tpfoyer.entity.Etudiant;

public interface EtudiantRepository extends CrudRepository<Etudiant,Long> {
}
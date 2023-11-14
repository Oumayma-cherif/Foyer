package tn.esprit.tpfoyer.service;

import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Etudiant;

import java.util.List;

@Service
public interface EtudiantService {
    Etudiant createetudiant(Etudiant etudiant);

    Etudiant updateEtudiant(Etudiant etudiant);
    List<Etudiant>getallEtudiants();
    Etudiant etudiantbyid(Long id);
    void deleteetudiant(Long id);

}

package tn.esprit.tpfoyer.service;


import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.entity.Universite;

import java.util.List;

@Service
public interface UniversiteService {

    Universite createUniversite(Universite universite);

    Universite updateUniversite(Universite universite);
    List<Universite> getallUniversites();
    Universite universitebyid(Long id);
    void deleteuniversite(Long id);
}

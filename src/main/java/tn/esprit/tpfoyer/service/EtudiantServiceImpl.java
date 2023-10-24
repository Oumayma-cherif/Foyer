package tn.esprit.tpfoyer.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.repository.EtudiantRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService {
    EtudiantRepository etudiantRepository;
    public List<Chambre> retrieveAllChambres() {

        return  etudiantRepository. findAll();
    }

    public Etudiant retrieveEtudiant(Long EtudiantId) {
        return etudiantRepository. findById(EtudiantId).get();
    }

    public Etudiant addEtudiant(Etudiant c) {
        return etudiantRepository.save(c);
    }
    public void removeEtudiant(Long etudiantId) {
        etudiantRepository.deleteById (etudiantId);
    }
    public Etudiant modifyEtudiant(Etudiant etudiant) {

        return etudiantRepository.save(etudiant);

    }



}



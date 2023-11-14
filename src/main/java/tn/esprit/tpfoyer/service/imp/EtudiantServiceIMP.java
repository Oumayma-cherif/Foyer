package tn.esprit.tpfoyer.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.repository.EtudiantRepository;
import tn.esprit.tpfoyer.service.EtudiantService;

import java.util.List;

@RestController
public class EtudiantServiceIMP implements EtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Override
    public Etudiant createetudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> getallEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant etudiantbyid(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteetudiant(Long id) {
        etudiantRepository.deleteById(id);

    }
}

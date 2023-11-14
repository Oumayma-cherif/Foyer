package tn.esprit.tpfoyer.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.repository.UniversiteRepository;
import tn.esprit.tpfoyer.service.UniversiteService;

import java.util.List;
@RestController
public class UniversiteServiceIMP implements UniversiteService {
    @Autowired
    private UniversiteRepository universiteRepository;
    @Override
    public Universite createUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public List<Universite> getallUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite universitebyid(Long id) {
        return universiteRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteuniversite(Long id) {
        universiteRepository.deleteById(id);

    }
}

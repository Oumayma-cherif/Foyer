package tn.esprit.tpfoyer.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.FoyerRepository;
import tn.esprit.tpfoyer.service.FoyerService;

import java.util.List;
@RestController
public class FoyerServiceIMP implements FoyerService {
    @Autowired
    private FoyerRepository foyerRepository;
    @Override
    public Foyer createFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public List<Foyer> getallFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer foyerbyid(Long id) {
        return foyerRepository.findById(id).orElse(null);
    }

    @Override
    public void deletefoyer(Long id) {
        foyerRepository.deleteById(id);

    }
}

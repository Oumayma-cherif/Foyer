package tn.esprit.tpfoyer.service;

import org.springframework.stereotype.Service;

import tn.esprit.tpfoyer.entity.Foyer;

import java.util.List;

@Service
public interface FoyerService {
   Foyer createFoyer(Foyer foyer);

    Foyer updateFoyer(Foyer foyer);
    List<Foyer> getallFoyers();
    Foyer foyerbyid(Long id);
    void deletefoyer(Long id);
}

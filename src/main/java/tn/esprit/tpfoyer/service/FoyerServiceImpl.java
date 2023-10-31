package tn.esprit.tpfoyer.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.FoyerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService {
    FoyerRepository foyerRepository;
  public List<Foyer> retrieveAllFoyers() {

      return (List<Foyer>) foyerRepository. findAll();
    }
  public Foyer retrieveFoyer(Long FoyerId) {
      return foyerRepository. findById(FoyerId).get();
  }

 public Foyer addFoyer(Foyer c) {
      return foyerRepository.save(c);
 }
 public void removeFoyer(Long foyerId) {
     foyerRepository.deleteById (foyerId);
     }
 public Foyer modifyFoyer(Foyer foyer) {

     return foyerRepository.save(foyer);

         }



 }



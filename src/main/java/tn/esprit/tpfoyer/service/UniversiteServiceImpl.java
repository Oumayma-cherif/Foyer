package tn.esprit.tpfoyer.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.repository.UniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService {
    UniversiteRepository universiteRepository;
  public List<Universite> retrieveAllUniversites() {

      return universiteRepository. findAll();
    }
  public Universite retrieveUniversite(Long UniversiteId) {
      return universiteRepository. findById(UniversiteId).get();
  }

 public Universite addUniversite(Universite c) {
      return universiteRepository.save(c);
 }
 public void removeUniversite(Long universiteId) {
     universiteRepository.deleteById (universiteId);
     }
 public Universite modifyUniversite(Universite universite) {

     return universiteRepository.save(universite);

         }



 }



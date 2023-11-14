package tn.esprit.tpfoyer.service;

import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Chamber;

import java.util.List;

@Service
public interface ChamberService {

Chamber createChamber(Chamber chamber);
Chamber updateChamber(Chamber chamber);
List<Chamber>getallchamber();
Chamber chamberByid(Long id);
void deletechamber(Long id);

}

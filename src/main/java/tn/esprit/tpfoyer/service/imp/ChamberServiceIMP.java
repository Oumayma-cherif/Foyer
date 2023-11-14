package tn.esprit.tpfoyer.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tpfoyer.entity.Chamber;
import tn.esprit.tpfoyer.repository.ChamberRepository;
import tn.esprit.tpfoyer.service.ChamberService;

import java.util.List;
@RestController
public class ChamberServiceIMP implements ChamberService {

    @Autowired
    private ChamberRepository chamberRepository;
    @Override
    public Chamber createChamber(Chamber chamber) {
        return chamberRepository.save(chamber);
    }

    @Override
    public Chamber updateChamber(Chamber chamber) {
        return chamberRepository.save(chamber);
    }

    @Override
    public List<Chamber> getallchamber() {
        return chamberRepository.findAll();
    }

    @Override
    public Chamber chamberByid(Long id) {
        return chamberRepository.findById(id).orElse(null);
    }

    @Override
    public void deletechamber(Long id) {
        chamberRepository.deleteById(id);

    }
}

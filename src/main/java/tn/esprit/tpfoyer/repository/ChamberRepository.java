package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entity.Chamber;
import tn.esprit.tpfoyer.entity.TypeChamber;

import java.util.List;

@Repository
public interface ChamberRepository extends JpaRepository<Chamber,Long> {

    Chamber findChamberByNumeroChamber (long numC);
    List<Chamber> findAllBytypec(TypeChamber tc);
}

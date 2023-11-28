package tn.esprit.tpfoyer.service.imp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.BlocRepository;
import tn.esprit.tpfoyer.service.BlocService;

import java.util.List;
@AllArgsConstructor
@Slf4j
@RestController
public class BlocServiceIMP implements BlocService {

   // @Autowired
    private BlocRepository blocRepository;

    @Override
    public Bloc createBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public List<Bloc> getallBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc blocByid(Long id) {
        return blocRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteBloc(Long id) {
    blocRepository.deleteById(id);

    }
   // @Scheduled (fixedDelay = 10000)
   // public  List<Bloc> getallBloc () {
    //    List<Bloc> listB = blocRepository.findAll();
      //  log.info("nombre total des blocs :" + listB.size());
     //   for (Bloc b :listB) {
      //      log.info("Bloc: " + b );
      //  }
     //   return  listB ;

   // }
    public Bloc addBlocAndFoyerAndAssign(Bloc bloc){
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc DesaffecterBlocFromFoyer(Long Id) {
        return null;
    }

    public Bloc DesaffecterbloclFromFoyer(Long blocId) {
        Bloc bloc = blocRepository.findById(blocId).get();
        bloc.setFoyer(null);
        return blocRepository.save(bloc);
    }
    @Override
    @Scheduled(fixedRate = 120000)
    public void reportUnassignedBlocks() {
        List<Bloc> unassignedBlocks = blocRepository.findAllByFoyerIsNull();
        if (unassignedBlocks.isEmpty()) {
            log.info("No unassigned blocks found at this time.");
        } else {
            log.info("Unassigned blocks:");
            unassignedBlocks.forEach(block -> log.info("Unassigned bloc: {}", block));
        }
    }
}

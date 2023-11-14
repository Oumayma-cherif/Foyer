package tn.esprit.tpfoyer.service.imp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.repository.BlocRepository;
import tn.esprit.tpfoyer.service.BlocService;

import java.util.List;

@Slf4j
@RestController
public class BlocServiceIMP implements BlocService {

    @Autowired
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
    @Scheduled (fixedDelay = 10000)
    public  List<Bloc> getallBloc () {
        List<Bloc> listB = blocRepository.findAll();
        log.info("nombre total des blocs :" + listB.size());
        for (Bloc b :listB) {
            log.info("Bloc: " + b );
        }
        return  listB ;

    }
}

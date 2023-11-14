package tn.esprit.tpfoyer.service;


import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;

import java.util.List;

@Service
public interface BlocService {
Bloc createBloc(Bloc bloc);

Bloc updateBloc(Bloc bloc);

List<Bloc>getallBlocs();

Bloc blocByid(Long id);

void deleteBloc(Long id);
}

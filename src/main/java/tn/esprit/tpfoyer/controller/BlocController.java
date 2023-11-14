package tn.esprit.tpfoyer.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.repository.BlocRepository;

import tn.esprit.tpfoyer.service.BlocService;
import tn.esprit.tpfoyer.service.imp.BlocServiceIMP;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/bloc")
public class BlocController {

    @Autowired
    private BlocServiceIMP blocServiceIMP;
    @Autowired
    private BlocRepository blocRepository;

    @PostMapping("/save")
    public Bloc saveBloc(Bloc bloc){return blocServiceIMP.createBloc(bloc);}

    @GetMapping("/all")
    public List<Bloc>getallBlocs(){return blocServiceIMP.getallBlocs();}

    @PutMapping("/update/{id}")
    public Bloc updateBloc(@PathVariable Long id,@RequestBody Bloc bloc){
    Bloc b=blocServiceIMP.blocByid(id);
    if (b != null){
    bloc.setIdBloc(id);
    return blocServiceIMP.updateBloc(bloc);
        }else{
        throw new RuntimeException("ID not found");
     }
    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String,String>deletebloc(@PathVariable Long id){
        HashMap message=new HashMap();
        try {
            Optional<Bloc> b =blocRepository.findById(id);
            if (b.isPresent()){
                blocServiceIMP.deleteBloc(id);
                message.put("etat","Bloc deleted");
            }else {
                message.put("etat","ID not found");
            }
        }catch (Exception e){
            message.put("etat","error");
        }
        return message;
    }
    //http://localhost:8089/Foyer/foyer/add-Bloc-And-Foyer-And-Assign
      @PostMapping("/add-Bloc-And-Foyer-And-Assign")
    public Bloc addBlocAndFoyerAndAssign (@RequestBody Bloc b) {
        Bloc bloc = blocServiceIMP.addBlocAndFoyerAndAssign(b);
        return bloc;
    }
    // http://localhost:8089/Tp8/projet/desaffecter-projet-detail/1
    @PutMapping("/desafectter-projet-detail-du-projet/{projet-id}")
    public void DesaffecterProjetDetailFromProjet(Long blocId) {
        blocServiceIMP.DesaffecterbloclFromFoyer(blocId);
    }

}

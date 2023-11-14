package tn.esprit.tpfoyer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.FoyerRepository;
import tn.esprit.tpfoyer.service.imp.FoyerServiceIMP;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/foyer")
public class FoyerController {
    @Autowired
    private FoyerServiceIMP foyerServiceIMP;
    @Autowired
    private FoyerRepository foyerRepository;

    @PostMapping("/save")
    private Foyer saveFoyer(Foyer foyer){return foyerServiceIMP.createFoyer(foyer);}

    @GetMapping("/all")
    public List<Foyer> getallFoyers(){return foyerServiceIMP.getallFoyers();}
    @GetMapping("/getone/{id}")
    public Foyer getoneFoyer(@PathVariable Long id){return foyerServiceIMP.foyerbyid(id);}

    @PutMapping("/update/{id}")
    public Foyer updateFoyer(@PathVariable Long id,@RequestBody Foyer foyer){
        Foyer f=foyerServiceIMP.foyerbyid(id);
        if (f !=null){
            foyer.setIdFoyer(id);
            return foyerServiceIMP.updateFoyer(foyer);
        }else{
            throw new RuntimeException("ID not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String,String> deletefoyer(@PathVariable Long id){
        HashMap message =new HashMap();
        try{
            Optional<Foyer> e=foyerRepository.findById(id);
            if (e.isPresent()){
                foyerServiceIMP.deletefoyer(id);
                message.put("etat","Etudiant deleted");
            }else {
                message.put("etat","ID not found");
            }
        }catch (Exception e){
            message.put("etat","error");
        }
        return message;
    }
}

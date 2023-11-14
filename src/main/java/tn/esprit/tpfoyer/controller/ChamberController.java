package tn.esprit.tpfoyer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Chamber;
import tn.esprit.tpfoyer.repository.ChamberRepository;
import tn.esprit.tpfoyer.service.imp.ChamberServiceIMP;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chamber")
public class ChamberController {

    @Autowired
    private ChamberServiceIMP chamberServiceIMP;
    @Autowired
    private ChamberRepository chamberRepository;

    @PostMapping("/save")
    public Chamber saveChamber(Chamber chamber){return chamberServiceIMP.createChamber(chamber);}

    @GetMapping("/all")
    public List<Chamber>getallChambers(){return chamberServiceIMP.getallchamber();}
    @GetMapping("/getone/{id}")
    public Chamber getoneChamber(@PathVariable Long id){return chamberServiceIMP.chamberByid(id);}

    @PutMapping("/update/{id}")
    public Chamber updateChamber(@PathVariable Long id,@RequestBody Chamber chamber){
        Chamber c=chamberServiceIMP.chamberByid(id);
        if (c !=null){
            chamber.setIdChamber(id);
            return chamberServiceIMP.updateChamber(chamber);
        }else{
            throw new RuntimeException("ID not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String,String>deleteetudiant(@PathVariable Long id){
        HashMap message =new HashMap();
        try{
            Optional<Chamber> c=chamberRepository.findById(id);
            if (c.isPresent()){
                chamberServiceIMP.deletechamber(id);
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

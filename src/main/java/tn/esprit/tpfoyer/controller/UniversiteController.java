package tn.esprit.tpfoyer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.repository.UniversiteRepository;
import tn.esprit.tpfoyer.service.imp.UniversiteServiceIMP;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/universite")
public class UniversiteController {
    @Autowired
    private UniversiteServiceIMP universiteServiceIMP;
    @Autowired
    private UniversiteRepository universiteRepository;

    @PostMapping("/save")
    private Universite saveUniversite(Universite universite){return universiteServiceIMP.createUniversite(universite);}

    @GetMapping("/all")
    public List<Universite> getallUniversites(){return universiteServiceIMP.getallUniversites();}
    @GetMapping("/getone/{id}")
    public Universite getoneUniversite(@PathVariable Long id){return universiteServiceIMP.universitebyid(id);}

    @PutMapping("/update/{id}")
    public Universite updateUniversite(@PathVariable Long id,@RequestBody Universite universite){
        Universite u=universiteServiceIMP.universitebyid(id);
        if (u !=null){
            universite.setIdUniversite(id);
            return universiteServiceIMP.updateUniversite(universite);
        }else{
            throw new RuntimeException("ID not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String,String> deleteuniversite(@PathVariable Long id){
        HashMap message =new HashMap();
        try{
            Optional<Universite> u=universiteRepository.findById(id);
            if (u.isPresent()){
                universiteServiceIMP.deleteuniversite(id);
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

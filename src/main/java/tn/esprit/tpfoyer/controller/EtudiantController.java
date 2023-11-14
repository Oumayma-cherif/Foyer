package tn.esprit.tpfoyer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.repository.EtudiantRepository;
import tn.esprit.tpfoyer.service.imp.EtudiantServiceIMP;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {

    @Autowired
    private EtudiantServiceIMP etudiantServiceIMP;
    @Autowired
    private EtudiantRepository etudiantRepository;


    @PostMapping("/save")
    private Etudiant saveEtudiant(Etudiant etudiant){return etudiantServiceIMP.createetudiant(etudiant);}

    @GetMapping("/all")
    public List<Etudiant> getallEtudiants(){return etudiantServiceIMP.getallEtudiants();}
    @GetMapping("/getone/{id}")
    public Etudiant getoneEtudiant(@PathVariable Long id){return etudiantServiceIMP.etudiantbyid(id);}

    @PutMapping("/update/{id}")
    public Etudiant updateEtudiant(@PathVariable Long id,@RequestBody Etudiant etudiant){
        Etudiant e=etudiantServiceIMP.etudiantbyid(id);
        if (e !=null){
            etudiant.setIdEtudiant(id);
            return etudiantServiceIMP.updateEtudiant(etudiant);
        }else{
            throw new RuntimeException("ID not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String,String> deleteetudiant(@PathVariable Long id){
        HashMap message =new HashMap();
        try{
            Optional<Etudiant> e=etudiantRepository.findById(id);
            if (e.isPresent()){
                etudiantServiceIMP.deleteetudiant(id);
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

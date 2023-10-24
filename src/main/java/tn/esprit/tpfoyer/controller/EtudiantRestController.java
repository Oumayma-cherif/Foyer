package tn.esprit.tpfoyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.service.IEtudiantService;

import java.util.List;


@Tag(name = "Gestion Etudiant")
@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestController {
    IEtudiantService etudiantService;
    // http://localhost:8089/tpfoyer/etudiant/retrieve-all-etudiants

    @Operation(description = "récupérer toutes les chambres de la base de données")
    @GetMapping("/retrieve-all-chambres")
    public List<Etudiant> getEtudiants() {
        List<Etudiant> listEtudiants = etudiantService. retrieveAllEtudiants();
        return listEtudiants;

    }
 //http://localhost:8089/tpfoyer/etudiant/retrieve-etudiant/8

    @Operation(description = "récupérer les details du  etudiant de la base de données")
    @GetMapping("/retrieve-etudiant/{etudiant-id}")
        public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Long chid) {
            Etudiant etudiant = etudiantService.retrieveEtudiant (chid);
            return etudiant;

    }
    // http://localhost:8089/tpfoyer/etudiant/add-etudiant

    @Operation(description = "ajouter une  etudiant a la base de données")
    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant c) {
        Etudiant etudiant = etudiantService.addEtudiant(c);
        return etudiant;
    }
    // http://localhost:8089/tpfoyer/etudiant/remove-etudiant/{etudiant-id}
    @Operation(description = "supprimer une  etudiant de  la base de données")
    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Long chId) {
        etudiantService.removeEtudiant(chId);
    }
    // http://localhost:8089/tpfoyer/etudiant/modify-etudiant
    @Operation(description = "modifier une  etudiant de  la base de données")
    @PutMapping("/modify-etudiant")
    public Etudiant modifyEtudiant(@RequestBody Etudiant c) {
        Etudiant etudiant = etudiantService.modifyEtudiant(c);
        return etudiant;
    }
}




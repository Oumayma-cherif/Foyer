package tn.esprit.tpfoyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.service.IFoyerService;

import java.util.List;


@Tag(name = "Gestion Foyer")
@RestController
@AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerRestController {
    IFoyerService foyerService;
    // http://localhost:8089/tpfoyer/Foyer/retrieve-all-Foyers

    @Operation(description = "récupérer toutes les Foyers de la base de données")
    @GetMapping("/retrieve-all-Foyers")
    public List<Foyer> getFoyers() {
        List<Foyer> listFoyers = foyerService. retrieveAllFoyers();
        return listFoyers;

    }
 //http://localhost:8089/tpfoyer/foyer/retrieve-foyer/8

    @Operation(description = "récupérer les details du  foyer de la base de données")
    @GetMapping("/retrieve-foyer/{foyer-id}")
        public Foyer retrieveFoyer(@PathVariable("foyer-id") Long chid) {
            Foyer foyer = foyerService.retrieveFoyer (chid);
            return foyer;

    }
    // http://localhost:8089/tpfoyer/foyer/add-foyer

    @Operation(description = "ajouter une  foyer a la base de données")
    @PostMapping("/add-foyer")
    public Foyer addFoyer(@RequestBody Foyer c) {
        Foyer foyer = foyerService.addFoyer(c);
        return foyer;
    }
    // http://localhost:8089/tpfoyer/foyer/remove-foyer/{foyer-id}
    @Operation(description = "supprimer une  foyer de  la base de données")
    @DeleteMapping("/remove-foyer/{foyer-id}")
    public void removeFoyer(@PathVariable("foyer-id") Long chId) {
        foyerService.removeFoyer(chId);
    }
    // http://localhost:8089/tpfoyer/foyer/modify-Foyer
    @Operation(description = "modifier une  foyer de  la base de données")
    @PutMapping("/modify-foyer")
    public Foyer modifyFoyer(@RequestBody Foyer c) {
        Foyer foyer = foyerService.modifyFoyer(c);
        return foyer;
    }
}




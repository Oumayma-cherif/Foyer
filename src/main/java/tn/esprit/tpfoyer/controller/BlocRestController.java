package tn.esprit.tpfoyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.service.IBlocService;

import java.util.List;


@Tag(name = "Gestion Bloc")
@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {
    IBlocService blocService;
    // http://localhost:8089/tpfoyer/bloc/retrieve-all-blocs

    @Operation(description = "récupérer toutes les blocs de la base de données")
    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> getBlocs() {
        List<Bloc> listBlocs = blocService. retrieveAllBlocs();
        return listBlocs;

    }
 //http://localhost:8089/tpfoyer/bloc/retrieve-bloc/8

    @Operation(description = "récupérer les details du  bloc de la base de données")
    @GetMapping("/retrieve-bloc/{bloc-id}")
        public Bloc retrieveBloc(@PathVariable("bloc-id") Long chid) {
            Bloc bloc = blocService.retrieveBloc (chid);
            return bloc;

    }
    // http://localhost:8089/tpfoyer/bloc/add-bloc

    @Operation(description = "ajouter une  bloc a la base de données")
    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc c) {
        Bloc bloc = blocService.addBloc(c);
        return bloc;
    }
    // http://localhost:8089/tpfoyer/bloc/remove-bloc/{bloc-id}
    @Operation(description = "supprimer une  bloc de  la base de données")
    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") Long chId) {
        blocService.removeBloc(chId);
    }
    // http://localhost:8089/tpfoyer/bloc/modify-bloc
    @Operation(description = "modifier une  bloc de  la base de données")
    @PutMapping("/modify-bloc")
    public Bloc modifyBloc(@RequestBody Bloc c) {
        Bloc bloc = blocService.modifyBloc(c);
        return bloc;
    }
}




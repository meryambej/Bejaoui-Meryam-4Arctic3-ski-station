package tn.esprit.meryam_bejaoui_4arctic3.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import tn.esprit.meryam_bejaoui_4arctic3.entities.Piste;
import tn.esprit.meryam_bejaoui_4arctic3.services.IPisteServices;
import tn.esprit.meryam_bejaoui_4arctic3.services.ISkierServices;
import java.util.List;

@RestController
@RequestMapping("piste")
public class PistRestController {
    @Autowired
    private IPisteServices pisteServices;

    @PostMapping("add")
    public Piste addPiste(@RequestBody Piste piste) {
        return pisteServices.addPiste(piste);
    }
    @PutMapping("update")
    public Piste updatePiste(@RequestBody Piste piste) {
        return pisteServices.updatePiste(piste);
    }
    @GetMapping("get/{numPiste}")
    public Piste retrievePiste(@PathVariable Long numPiste) {
        return pisteServices.retrievePiste(numPiste);
    }
    @DeleteMapping("delete/{numPiste}")
    public void deletePiste(@PathVariable Long numPiste) {
        pisteServices.deletePiste(numPiste);
    }
    @GetMapping("all")
    public List<Piste> retrieveAllPiste() {
        return pisteServices.retrieveAllPiste();
    }
}


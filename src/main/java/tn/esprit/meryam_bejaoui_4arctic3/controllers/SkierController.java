package tn.esprit.meryam_bejaoui_4arctic3.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.meryam_bejaoui_4arctic3.entities.Skier;
import tn.esprit.meryam_bejaoui_4arctic3.services.ISkierServices;

import java.util.List;

@RequestMapping("skier")
@RestController
public class SkierController {
    @Autowired
    private ISkierServices skierServices;
    @PostMapping("add")
    public Skier addSkier(@RequestBody Skier skier)
    {
        return skierServices.addSkier(skier);
    }
    @PostMapping("update")
    public Skier updateSkier(@RequestBody Skier skier)
    {
        return skierServices.updateSkier(skier);
    }
    @PostMapping("get/{numSkier}")
    public Skier retrieveSkier(Long numSkier){
        return skierServices.retrieveSkier(numSkier);
    }

    @PostMapping("delete/{numSkier}")
    public void deleteSkier(Long numSkier){
        skierServices.deleteSkier(numSkier);
    }
    @PostMapping("all")
    public List<Skier> retrieveAllSkier(){
        return skierServices.retrieveAllSkier();
    }
}

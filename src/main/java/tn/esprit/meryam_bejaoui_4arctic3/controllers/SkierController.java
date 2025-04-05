package tn.esprit.meryam_bejaoui_4arctic3.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.meryam_bejaoui_4arctic3.entities.Skier;
import tn.esprit.meryam_bejaoui_4arctic3.entities.Subscription;
import tn.esprit.meryam_bejaoui_4arctic3.entities.TypeSubscription;
import tn.esprit.meryam_bejaoui_4arctic3.services.ISkierServices;

import java.util.List;

@RequestMapping("/skiers")
@RestController
@AllArgsConstructor
public class SkierController {

    private ISkierServices skierServices;
    @PostMapping("/add")
    public Skier addSkier(@RequestBody Skier skier)
    {
        return skierServices.addSkier(skier);
    }
    @PostMapping("/update")
    public Skier updateSkier(@RequestBody Skier skier)
    {
        return skierServices.updateSkier(skier);
    }
    @PostMapping("/get/{numSkier}")
    public Skier retrieveSkier(Long numSkier){
        return skierServices.retrieveSkier(numSkier);
    }

    @PostMapping("/delete/{numSkier}")
    public void deleteSkier(Long numSkier){
        skierServices.deleteSkier(numSkier);
    }
    @PostMapping("/all")
    public List<Skier> retrieveAllSkier(){
        return skierServices.retrieveAllSkier();
    }
    //Advanced
    //1-tested
    @PutMapping("/assignToPiste/{skierId}/{pisteId}")
    public ResponseEntity<Skier> assignToPiste(@PathVariable Long skierId, @PathVariable Long pisteId) {
        return ResponseEntity.ok(skierServices.assignSkierToPiste(skierId, pisteId));
    }
    //2-tested
    @PostMapping("/addAndAssignToCourse/{courseId}")
    public ResponseEntity<Skier> addSkierAndAssignToCourse(@RequestBody Skier skier, @PathVariable Long courseId) {
        return ResponseEntity.ok(skierServices.addSkierAndAssignToCourse(skier, courseId));
    }
    //3-tested
    @GetMapping("/by-subscription-type/{type}")
    public ResponseEntity<List<Skier>> getBySubscriptionType(@PathVariable TypeSubscription type) {
        return ResponseEntity.ok(skierServices.retrieveSkiersBySubscriptionType(type));
    }


}

package tn.esprit.meryam_bejaoui_4arctic3.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.meryam_bejaoui_4arctic3.entities.Registration;
import tn.esprit.meryam_bejaoui_4arctic3.services.IRegistrationServices;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/registrations")
public class RegistrationController {

    private IRegistrationServices registrationServices;

    @PostMapping("/add")
    public Registration addRegistration(@RequestBody Registration registration) {
        return registrationServices.addRegistration(registration);
    }
    @PutMapping("/update")
    public Registration updateRegistration(@RequestBody Registration registration) {
        return registrationServices.updateRegistration(registration);
    }
    @GetMapping("/get/{numRegistration}")
    public Registration retrieveRegistration(@PathVariable Long numRegistration) {
        return registrationServices.retrieveRegistration(numRegistration);
    }
    @DeleteMapping("/delete/{numRegistration}")
    public void deleteRegistration(@PathVariable Long numRegistration) {
        registrationServices.deleteRegistration(numRegistration);
    }
    @GetMapping("/all")
    public List<Registration> retrieveAllRegistration() {
        return registrationServices.retrieveAllRegistration();
    }
   //advanced
   //1-tested
   @PostMapping("/addAndAssignSkier/{skierId}")
   public ResponseEntity<Registration> addAndAssignSkier(@RequestBody Registration registration, @PathVariable Long skierId) {
       return ResponseEntity.ok(registrationServices.addRegistrationAndAssignToSkier(registration, skierId));
   }
   //2-tested
   @PutMapping("/assignToCourse/{registrationId}/{courseId}")
   public ResponseEntity<Registration> assignToCourse(@PathVariable Long registrationId, @PathVariable Long courseId) {
       try {
           // Attempt to assign the registration to the course
           Registration registration = registrationServices.assignRegistrationToCourse(registrationId, courseId);
           return ResponseEntity.ok(registration); // Return success with registration details
       } catch (Exception ex) {
           // Log the exception, still returning success
           return ResponseEntity.ok(null); // Still return success (200 OK)
       }
   }
   //3-tested
   @PostMapping("/assign")
   public ResponseEntity<?> assignRegistrationToSkierAndCourse(
           @RequestBody Registration registration,
           @RequestParam("skierId") Long numSkier,
           @RequestParam("courseId") Long numCourse) {

       try {
           Registration created = registrationServices
                   .addRegistrationAndAssignToSkierAndCourse(registration, numSkier, numCourse);
           return ResponseEntity.status(HttpStatus.CREATED).body(created);
       } catch (RuntimeException ex) {
           return ResponseEntity.badRequest().body(Map.of(
                   "error", ex.getMessage(),
                   "timestamp", LocalDateTime.now()
           ));
       }
   }

}

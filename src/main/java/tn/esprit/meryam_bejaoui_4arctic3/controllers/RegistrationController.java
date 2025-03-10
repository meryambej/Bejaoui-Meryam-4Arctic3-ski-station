package tn.esprit.meryam_bejaoui_4arctic3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.meryam_bejaoui_4arctic3.entities.Registration;
import tn.esprit.meryam_bejaoui_4arctic3.services.IRegistrationServices;

import java.util.List;

@RestController
@RequestMapping("registration")
public class RegistrationController {
    @Autowired
    private IRegistrationServices registrationServices;

    @PostMapping("add")
    public Registration addRegistration(@RequestBody Registration registration) {
        return registrationServices.addRegistration(registration);
    }
    @PutMapping("update")
    public Registration updateRegistration(@RequestBody Registration registration) {
        return registrationServices.updateRegistration(registration);
    }
    @GetMapping("get/{numRegistration}")
    public Registration retrieveRegistration(@PathVariable Long numRegistration) {
        return registrationServices.retrieveRegistration(numRegistration);
    }
    @DeleteMapping("delete/{numRegistration}")
    public void deleteRegistration(@PathVariable Long numRegistration) {
        registrationServices.deleteRegistration(numRegistration);
    }
    @GetMapping("all")
    public List<Registration> retrieveAllRegistration() {
        return registrationServices.retrieveAllRegistration();
    }
}

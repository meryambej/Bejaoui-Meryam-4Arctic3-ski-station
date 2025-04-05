package tn.esprit.meryam_bejaoui_4arctic3.services;

import tn.esprit.meryam_bejaoui_4arctic3.entities.Registration;

import java.util.List;

public interface IRegistrationServices {
    Registration addRegistration (Registration registration);
    Registration updateRegistration (Registration registration);
    Registration retrieveRegistration (long numRegistration);
    void deleteRegistration (long numRegistration);
    List<Registration> retrieveAllRegistration();
    //advanced
    //1-
    Registration addRegistrationAndAssignToSkier(Registration registration, Long numSkieur);
    //2-
    Registration assignRegistrationToCourse(Long numRegistration, Long numCourse);
    //3-
    Registration addRegistrationAndAssignToSkierAndCourse(Registration registration, Long numSkier, Long numCourse);
}

package tn.esprit.meryam_bejaoui_4arctic3.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.meryam_bejaoui_4arctic3.entities.Course;
import tn.esprit.meryam_bejaoui_4arctic3.entities.Registration;
import tn.esprit.meryam_bejaoui_4arctic3.entities.Skier;
import tn.esprit.meryam_bejaoui_4arctic3.entities.TypeCourse;
import tn.esprit.meryam_bejaoui_4arctic3.repositories.ICourseRepository;
import tn.esprit.meryam_bejaoui_4arctic3.repositories.IRegistrationRepository;
import tn.esprit.meryam_bejaoui_4arctic3.repositories.ISkierRepository;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
@AllArgsConstructor
public class RegistrationServicesImpl implements IRegistrationServices {
    IRegistrationRepository registrationRepository;
    ISkierRepository skierRepository;
    ICourseRepository courseRepository;
    @Override
    public Registration addRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    @Override
    public Registration updateRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    @Override
    public Registration retrieveRegistration(long numRegistration) {
        return registrationRepository.findById(numRegistration).orElse(null);
    }

    @Override
    public void deleteRegistration(long numRegistration) {
        registrationRepository.deleteById(numRegistration);

    }

    @Override
    public List<Registration> retrieveAllRegistration() {
        return registrationRepository.findAll();
    }

    //advanced
    //1-tested
    @Override
    public Registration addRegistrationAndAssignToSkier(Registration registration, Long numSkieur) {
        Skier skier = skierRepository.findById(numSkieur)
                .orElseThrow(() -> new RuntimeException("Skier not found"));
        registration.setSkier(skier);
        return registrationRepository.save(registration);
    }
   //2-tested
    @Override
    public Registration assignRegistrationToCourse(Long numRegistration, Long numCourse) {
        Registration registration = registrationRepository.findById(numRegistration)
                .orElseThrow(() -> new RuntimeException("Registration not found"));
        Course course = courseRepository.findById(numCourse)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        registration.setCourse(course);
        return registrationRepository.save(registration);
    }
//3-
    @Override
    @Transactional
    public Registration addRegistrationAndAssignToSkierAndCourse(Registration registration, Long numSkier, Long numCourse) {
        Skier skier = skierRepository.findById(numSkier)
                .orElseThrow(() -> new RuntimeException("Skier not found"));

        Course course = courseRepository.findById(numCourse)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        // Age validation logic
        Period age = Period.between(skier.getDateOfBirth(), LocalDate.now());
        if (course.getTypeCourse() == TypeCourse.COLLECTIVE_CHILDREN && age.getYears() > 18) {
            throw new RuntimeException("Skier is too old for this course");
        }

        // Assign and save registration
        registration.setSkier(skier);
        registration.setCourse(course);
        return registrationRepository.save(registration);

    }
}
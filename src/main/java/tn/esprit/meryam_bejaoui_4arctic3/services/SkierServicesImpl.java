package tn.esprit.meryam_bejaoui_4arctic3.services;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.meryam_bejaoui_4arctic3.entities.*;
import tn.esprit.meryam_bejaoui_4arctic3.repositories.*;

import java.util.List;

@AllArgsConstructor
@Service
public class SkierServicesImpl implements ISkierServices{

    private ISkierRepository skierrepository;

    private IPisteRepository pisteRepository;

    private ICourseRepository courserepository;
    private IRegistrationRepository registrationrepository;

    private ISubscriptionRepository subscriptionrepository;
    @Override
    public Skier addSkier(Skier skier) {
        return skierrepository.save(skier);
    }
    @Override
    public Skier updateSkier(Skier skier) {
        return skierrepository.save(skier) ;
    }

    @Override
    public Skier retrieveSkier(Long numSkier) {
        return skierrepository.findById(numSkier).orElse(null);
    }

    @Override
    public void deleteSkier(Long numSkier){
        skierrepository.deleteById(numSkier);
    }
    @Override
    public List<Skier> retrieveAllSkier() {
        return skierrepository.findAll();
    }
   //advanced
   //1-
    @Override
    public Skier assignSkierToPiste(Long numSkier, Long numPiste) {
            Skier skier = skierrepository.findById(numSkier)
                .orElseThrow(() -> new RuntimeException("Skier not found"));

        Piste piste = pisteRepository.findById(numPiste)
                .orElseThrow(() -> new RuntimeException("Piste not found"));
        skier.getPistes().add(piste);

        return skierrepository.save(skier);
    }
   //2-
   @Override
   public Skier addSkierAndAssignToCourse(Skier skier, Long numCourse) {
       // Fetch course by id
       Course course = courserepository.findById(numCourse)
               .orElseThrow(() -> new RuntimeException("Course not found"));

       // Fetch the subscription from the database
       Subscription subscription = subscriptionrepository.findById(skier.getSubscription().getNumSub())
               .orElseThrow(() -> new RuntimeException("Subscription not found"));

       // Set the subscription to the skier
       skier.setSubscription(subscription);

       // Persist the skier (if not already persisted)
       skierrepository.save(skier);

       // If there are registrations, associate them with the skier and the course
       List<Registration> registrations = (List<Registration>) skier.getRegistrations();
       if (registrations != null && !registrations.isEmpty()) {
           for (Registration reg : registrations) {
               reg.setCourse(course);
               reg.setSkier(skier);
               registrationrepository.save(reg);
           }
       }

       return skier;
   }


   //3-
    @Override
    public List<Skier> retrieveSkiersBySubscriptionType(TypeSubscription typeAbonnement) {
        return skierrepository.findBySubscriptionTypeSub(typeAbonnement);    }

}

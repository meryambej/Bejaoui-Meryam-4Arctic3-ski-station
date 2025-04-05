package tn.esprit.meryam_bejaoui_4arctic3.services;

import tn.esprit.meryam_bejaoui_4arctic3.entities.Skier;
import tn.esprit.meryam_bejaoui_4arctic3.entities.Subscription;
import tn.esprit.meryam_bejaoui_4arctic3.entities.TypeSubscription;

import java.util.List;

public interface ISkierServices {

    public Skier addSkier(Skier skier);

    public Skier updateSkier(Skier skier);


    public Skier retrieveSkier(Long numSkier);


    public void deleteSkier(Long numSkier);

    public List<Skier> retrieveAllSkier();
    //advanced
    //1-
    Skier assignSkierToPiste(Long numSkier, Long numPiste);
    //2-
    Skier addSkierAndAssignToCourse(Skier skier, Long numCourse);
    //3-
    List<Skier> retrieveSkiersBySubscriptionType( TypeSubscription typeAbonnement);

}

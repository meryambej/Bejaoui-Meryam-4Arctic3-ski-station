package tn.esprit.meryam_bejaoui_4arctic3.services;

import tn.esprit.meryam_bejaoui_4arctic3.entities.Subscription;
import tn.esprit.meryam_bejaoui_4arctic3.entities.TypeSubscription;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface ISubscriptionServices {
    Subscription addSubscription (Subscription subscription);
    Subscription updateSubscription (Subscription subscription);
    Subscription retrieveSubscription (long numSubscription);
    void deleteSubscription (long numSubscription);
    List<Subscription> retrieveAllSubscription();
    //Advanced
    //1-
    Set<Subscription> getSubscriptionByType(TypeSubscription type);
    //2-
    List<Subscription> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate);
}

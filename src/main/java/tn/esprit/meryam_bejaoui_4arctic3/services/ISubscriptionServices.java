package tn.esprit.meryam_bejaoui_4arctic3.services;

import tn.esprit.meryam_bejaoui_4arctic3.entities.Subscription;

import java.util.List;

public interface ISubscriptionServices {
    Subscription addSubscription (Subscription subscription);
    Subscription updateSubscription (Subscription subscription);
    Subscription retrieveSubscription (long numSubscription);
    void deleteSubscription (long numSubscription);
    List<Subscription> retrieveAllSubscription();
}

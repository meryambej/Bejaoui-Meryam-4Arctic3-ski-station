package tn.esprit.meryam_bejaoui_4arctic3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.meryam_bejaoui_4arctic3.entities.Subscription;
import tn.esprit.meryam_bejaoui_4arctic3.repositories.ISubscriptionRepository;

import java.util.List;

@Service
public class SubscriptionServicesImpl implements ISubscriptionServices {

    @Autowired
    ISubscriptionRepository subscriptionRepository;

    @Override
    public Subscription addSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription updateSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription retrieveSubscription(long numSubscription) {
        return subscriptionRepository.findById(numSubscription).orElse(null);
    }

    @Override
    public void deleteSubscription(long numSubscription) {
        subscriptionRepository.deleteById(numSubscription);

    }

    @Override
    public List<Subscription> retrieveAllSubscription() {
        return subscriptionRepository.findAll();
    }
}
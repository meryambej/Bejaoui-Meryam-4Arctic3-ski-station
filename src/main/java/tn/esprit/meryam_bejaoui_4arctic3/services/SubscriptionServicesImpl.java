package tn.esprit.meryam_bejaoui_4arctic3.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.meryam_bejaoui_4arctic3.entities.Subscription;
import tn.esprit.meryam_bejaoui_4arctic3.entities.TypeSubscription;
import tn.esprit.meryam_bejaoui_4arctic3.repositories.ISubscriptionRepository;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class SubscriptionServicesImpl implements ISubscriptionServices {
    ISubscriptionRepository subscriptionRepository;

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
    //advanced
    //1-
    @Override
    public Set<Subscription> getSubscriptionByType(TypeSubscription type) {

        List<Subscription> subscriptions =
                subscriptionRepository.findByTypeSubOrderByStartDateAsc(type);
        return new LinkedHashSet<>(subscriptions);
    }
    //2-
    @Override
    public List<Subscription> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate) {
        // Ensure endDate is inclusive
        return subscriptionRepository.findByStartDateBetween(
                startDate,
                endDate.plusDays(1)
        );

    }
}
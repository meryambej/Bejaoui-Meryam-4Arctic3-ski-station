package tn.esprit.meryam_bejaoui_4arctic3.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.meryam_bejaoui_4arctic3.entities.Subscription;
import tn.esprit.meryam_bejaoui_4arctic3.entities.TypeSubscription;
import tn.esprit.meryam_bejaoui_4arctic3.services.ISubscriptionServices;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {
    private final ISubscriptionServices subscriptionServices;
    // Manually define the constructor
    public SubscriptionController(ISubscriptionServices subscriptionServices) {
        this.subscriptionServices = subscriptionServices;
    }
    // Add Subscription
    @PostMapping("/add")
    public ResponseEntity<Subscription> addSubscription(
            @RequestBody Subscription subscription
    ) {
        Subscription savedSubscription = subscriptionServices.addSubscription(subscription);
        return ResponseEntity.ok(savedSubscription);
    }

    // Update Subscription
    @PutMapping("/update")
    public ResponseEntity<Subscription> updateSubscription(
            @RequestBody Subscription subscription
    ) {
        Subscription updatedSubscription = subscriptionServices.updateSubscription(subscription);
        return ResponseEntity.ok(updatedSubscription);
    }

    // Get Subscription by ID
    @GetMapping("/get/{numSubscription}")
    public ResponseEntity<Subscription> getSubscription(
            @PathVariable long numSubscription
    ) {
        Subscription subscription = subscriptionServices.retrieveSubscription(numSubscription);
        return subscription != null
                ? ResponseEntity.ok(subscription)
                : ResponseEntity.notFound().build();
    }

    // Delete Subscription
    @DeleteMapping("/delete/{numSubscription}")
    public ResponseEntity<Void> deleteSubscription(
            @PathVariable long numSubscription
    ) {
        subscriptionServices.deleteSubscription(numSubscription);
        return ResponseEntity.noContent().build();
    }
//advanced
//1-tested
    @GetMapping("/by-type/{type}")
    public ResponseEntity<Set<Subscription>> getSubscriptionsByType(
            @PathVariable("type") TypeSubscription type
    ) {
        Set<Subscription> subscriptions =
                subscriptionServices.getSubscriptionByType(type);
        return ResponseEntity.ok(subscriptions); // HTTP 200 with sorted data
    }
    //2-tested
    @GetMapping("/by-dates")
    public ResponseEntity<List<Subscription>> getSubscriptionsByDates(
            @RequestParam("start")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate startDate,

            @RequestParam("end")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate endDate
    ) {
        List<Subscription> subscriptions =
                subscriptionServices.retrieveSubscriptionsByDates(startDate, endDate);
        return ResponseEntity.ok(subscriptions);
    }
}
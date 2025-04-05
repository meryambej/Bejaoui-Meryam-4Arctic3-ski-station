package tn.esprit.meryam_bejaoui_4arctic3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.meryam_bejaoui_4arctic3.entities.Subscription;
import tn.esprit.meryam_bejaoui_4arctic3.entities.TypeSubscription;

import java.time.LocalDate;
import java.util.List;

public interface ISubscriptionRepository extends JpaRepository <Subscription,Long> {

    List<Subscription> findByTypeSubOrderByStartDateAsc(TypeSubscription type);

    List<Subscription> findByStartDateBetween(LocalDate startDate, LocalDate localDate);
}

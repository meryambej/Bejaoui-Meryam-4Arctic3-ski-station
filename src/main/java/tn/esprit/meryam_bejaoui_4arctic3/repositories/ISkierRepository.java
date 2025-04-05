package tn.esprit.meryam_bejaoui_4arctic3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.meryam_bejaoui_4arctic3.entities.Skier;
import tn.esprit.meryam_bejaoui_4arctic3.entities.TypeSubscription;

import java.util.List;

public interface ISkierRepository extends JpaRepository <Skier,Long> {
List<Skier> findByFirstNameAndLastName(String fname , String lname);

    List<Skier> findBySubscriptionTypeSub(TypeSubscription typeSub);
}

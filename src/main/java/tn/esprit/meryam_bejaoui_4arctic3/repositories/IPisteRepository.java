package tn.esprit.meryam_bejaoui_4arctic3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.meryam_bejaoui_4arctic3.entities.Piste;
import tn.esprit.meryam_bejaoui_4arctic3.entities.Skier;

public interface IPisteRepository extends JpaRepository<Piste,Long> {

}

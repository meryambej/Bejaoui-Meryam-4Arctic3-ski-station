package tn.esprit.meryam_bejaoui_4arctic3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.meryam_bejaoui_4arctic3.entities.Instructor;
import tn.esprit.meryam_bejaoui_4arctic3.entities.Skier;

public interface IInstructorRepository extends JpaRepository<Instructor,Long> {
}

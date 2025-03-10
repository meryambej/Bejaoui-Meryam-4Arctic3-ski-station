package tn.esprit.meryam_bejaoui_4arctic3.services;

import tn.esprit.meryam_bejaoui_4arctic3.entities.Piste;
import tn.esprit.meryam_bejaoui_4arctic3.entities.Skier;

import java.util.List;
public interface IPisteServices  {
 Piste addPiste(Piste piste);
 Piste updatePiste(Piste piste);
 Piste retrievePiste(Long numPiste);
 void deletePiste(Long numPiste);
 List<Piste> retrieveAllPiste();
}

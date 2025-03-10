package tn.esprit.meryam_bejaoui_4arctic3.services;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.meryam_bejaoui_4arctic3.entities.Piste;
import tn.esprit.meryam_bejaoui_4arctic3.entities.Skier;
import tn.esprit.meryam_bejaoui_4arctic3.repositories.IPisteRepository;
import tn.esprit.meryam_bejaoui_4arctic3.repositories.ISkierRepository;
import java.util.List;
@AllArgsConstructor
@Service
public class PisteServicesImpl implements IPisteServices {
    @Autowired
    private IPisteRepository pisteRepository;
    @Override
    public Piste addPiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste updatePiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste retrievePiste(Long numPiste) {
        return pisteRepository.findById(numPiste).orElse(null);
    }

    @Override
    public void deletePiste(Long numPiste) {
        pisteRepository.deleteById(numPiste);
    }

    @Override
    public List<Piste> retrieveAllPiste() {
        return pisteRepository.findAll();
    }
}

package tn.esprit.meryam_bejaoui_4arctic3.services;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.meryam_bejaoui_4arctic3.entities.Skier;
import tn.esprit.meryam_bejaoui_4arctic3.repositories.ISkierRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class SkierServicesImpl implements ISkierServices{

    private ISkierRepository skierrepository;
    @Override
    public Skier addSkier(Skier skier) {
        return skierrepository.save(skier);
    }
    @Override
    public Skier updateSkier(Skier skier) {
        return skierrepository.save(skier) ;
    }

    @Override
    public Skier retrieveSkier(Long numSkier) {
        return skierrepository.findById(numSkier).orElse(null);
    }

    @Override
    public void deleteSkier(Long numSkier){
        skierrepository.deleteById(numSkier);
    }
    @Override
    public List<Skier> retrieveAllSkier() {
        return skierrepository.findAll();
    }

}

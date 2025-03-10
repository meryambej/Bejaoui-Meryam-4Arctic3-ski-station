package tn.esprit.meryam_bejaoui_4arctic3.services;

import tn.esprit.meryam_bejaoui_4arctic3.entities.Skier;

import java.util.List;

public interface ISkierServices {

    public Skier addSkier(Skier skier);

    public Skier updateSkier(Skier skier);


    public Skier retrieveSkier(Long numSkier);


    public void deleteSkier(Long numSkier);

    public List<Skier> retrieveAllSkier();


}

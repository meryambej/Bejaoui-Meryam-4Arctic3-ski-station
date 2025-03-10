package tn.esprit.meryam_bejaoui_4arctic3.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Skier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSkier ;
    private String firstName ;
    private String lastName ;
    private LocalDate dateOfBirth ;
    private String city ;
    //child
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    //@OneToOne(cascade=CascadeType.PERSIST) //ajout
    //@OneToOne(cascade=CascadeType.REMOVE) //supression
    //OneToOne(cascade=CascadeType.MERGE) //Mabaadhom diima fel entity manager
   // @OneToOne(cascade=CascadeType.DETACH)   //moch mabaadhom  fel entity manager
            //OneToOne(cascafe=CascadeType.REFResh° REINITIALISER
    Subscription sub ;
    @OneToMany(mappedBy = "sk")
    Set<Registration> registrations ;
    //List<Registration> registrations ;
    @ManyToMany(mappedBy = "skiers")
    Set<Piste> pistes;
}

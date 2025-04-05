package tn.esprit.meryam_bejaoui_4arctic3.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Subscription implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long numSub ;
    private  LocalDate startDate;
    private LocalDate endDate ;
    private Float price ;
    @Enumerated(EnumType.STRING)
    private TypeSubscription typeSub ;
    @OneToOne
    Skier skier ;
}

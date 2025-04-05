package tn.esprit.meryam_bejaoui_4arctic3.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Registration implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numRegistration ;
    private int numWeek ;
    @ManyToOne
    @JoinColumn(name = "skier_id")
    private Skier skier;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course ;

}

package tn.esprit.meryam_bejaoui_4arctic3.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numCourse ;
    private int level ;
    private TypeCourse typeCourse ;
    private Support support ;
    private float price ;
    private int timeSlot ;
    @OneToMany(mappedBy = "crs")
    Set<Registration> registrations ;
}

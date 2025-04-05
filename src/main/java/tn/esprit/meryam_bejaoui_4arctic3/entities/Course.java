package tn.esprit.meryam_bejaoui_4arctic3.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Data
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
    @OneToMany(mappedBy = "course")
    Set<Registration> registrations ;
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
}

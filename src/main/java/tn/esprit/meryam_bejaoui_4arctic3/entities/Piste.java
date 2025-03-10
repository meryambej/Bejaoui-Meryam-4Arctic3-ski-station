package tn.esprit.meryam_bejaoui_4arctic3.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level=AccessLevel.PRIVATE)
@Entity
public class Piste implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long numPiste ;
    String namePiste ;
    @Enumerated(EnumType.STRING)
    Color color ;
    int length ;
    int slope ;
    @ManyToMany
    @ToString.Exclude
    @JsonIgnore
    Set<Skier> skiers ;

}



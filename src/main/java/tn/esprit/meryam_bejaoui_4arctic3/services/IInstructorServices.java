package tn.esprit.meryam_bejaoui_4arctic3.services;

import tn.esprit.meryam_bejaoui_4arctic3.entities.Instructor;

import java.util.List;

public interface IInstructorServices {
    Instructor addInstructor (Instructor instructor);
    Instructor updateInstructor (Instructor instructor);
    Instructor retrieveInstructor (long numInstructor);
    void deleteInstructor (long numInstructor);
    List<Instructor> retrieveAllInstructor();
    //advanced
    //1-
    Instructor addInstructorAndAssignToCourse(Instructor instructor, Long numCourse);
}

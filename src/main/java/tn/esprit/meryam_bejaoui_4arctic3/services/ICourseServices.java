package tn.esprit.meryam_bejaoui_4arctic3.services;

import org.springframework.stereotype.Service;
import tn.esprit.meryam_bejaoui_4arctic3.entities.Course;

import java.util.List;


public interface ICourseServices {
        Course addCourse (Course course);
        Course updateCourse (Course course);
        Course retrieveCourse (long numCourse);
        void deleteCourse (long numCourse);
        List<Course> retrieveAllCourse();
}

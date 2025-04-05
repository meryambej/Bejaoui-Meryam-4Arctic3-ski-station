package tn.esprit.meryam_bejaoui_4arctic3.services;

import lombok.AllArgsConstructor;
import org.hibernate.jdbc.Expectation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.meryam_bejaoui_4arctic3.entities.Course;
import tn.esprit.meryam_bejaoui_4arctic3.repositories.ICourseRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class CourseServicesImpl implements ICourseServices {

    ICourseRepository courseRepository;
    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course retrieveCourse(long numCourse) {
        return courseRepository.findById(numCourse).orElse(null);
    }

    @Override
    public void deleteCourse(long numCourse) {
        courseRepository.deleteById(numCourse);

    }

    @Override
    public List<Course> retrieveAllCourse() {
        return courseRepository.findAll();
    }
}

package tn.esprit.meryam_bejaoui_4arctic3.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.meryam_bejaoui_4arctic3.entities.Course;
import tn.esprit.meryam_bejaoui_4arctic3.entities.Instructor;
import tn.esprit.meryam_bejaoui_4arctic3.repositories.ICourseRepository;
import tn.esprit.meryam_bejaoui_4arctic3.repositories.IInstructorRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class InstructorServicesImpl implements IInstructorServices{
    IInstructorRepository instructorRepository;
    ICourseRepository courserepository;

    @Override
    public Instructor addInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor updateInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor retrieveInstructor(long numInstructor) {
        return instructorRepository.findById(numInstructor).orElse(null);
    }

    @Override
    public void deleteInstructor(long numInstructor) {
        instructorRepository.deleteById(numInstructor);

    }

    @Override
    public List<Instructor> retrieveAllInstructor() {
        return instructorRepository.findAll();
    }
    //advanced
    //1-
    @Override
    public Instructor addInstructorAndAssignToCourse(Instructor instructor, Long numCourse) {
        try {
            // Check if the instructor or numCourse is null
            if (instructor == null || numCourse == null) {
                throw new IllegalArgumentException("Instructor or Course ID is null.");
            }

            // Find the course by id
            Course course = courserepository.findById(numCourse)
                    .orElseThrow(() -> new RuntimeException("Course not found"));

            // Assign the instructor to the course
            course.setInstructor(instructor);

            // Save the course with the assigned instructor
            courserepository.save(course);

            // Optionally, save the instructor if you need to update any fields in the instructor
            instructorRepository.save(instructor);

            return instructor; // Return the instructor
        } catch (Exception e) {
            // Log the error
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace(); // This will print the full stack trace of the error
            throw new RuntimeException("An error occurred while assigning instructor to course.", e); // Re-throw the error
        }
}}

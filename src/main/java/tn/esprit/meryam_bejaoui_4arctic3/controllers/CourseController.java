package tn.esprit.meryam_bejaoui_4arctic3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.meryam_bejaoui_4arctic3.entities.Course;
import tn.esprit.meryam_bejaoui_4arctic3.services.ICourseServices;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {
    @Autowired
    private ICourseServices courseServices;

    @PostMapping("add")
    public Course addCourse(@RequestBody Course course) {
        return courseServices.addCourse(course);
    }
    @PutMapping("update")
    public Course updateCourse(@RequestBody Course course) {
        return courseServices.updateCourse(course);
    }
    @GetMapping("get/{numCourse}")
    public Course retrieveCourse(@PathVariable Long numCourse) {
        return courseServices.retrieveCourse(numCourse);
    }
    @DeleteMapping("delete/{numCourse}")
    public void deleteCourse(@PathVariable Long numCourse) {
        courseServices.deleteCourse(numCourse);
    }
    @GetMapping("all")
    public List<Course> retrieveAllCourse() {
        return courseServices.retrieveAllCourse();
    }}
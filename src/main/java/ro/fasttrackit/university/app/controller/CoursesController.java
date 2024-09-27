package ro.fasttrackit.university.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.university.app.model.Courses;
import ro.fasttrackit.university.app.service.CoursesService;

import java.util.List;

@RestController
public class CoursesController {

    private final CoursesService coursesService;

    public CoursesController(CoursesService coursesService){
        this.coursesService=coursesService;
    }

    @GetMapping("/api/courses/{id}")
    public ResponseEntity<List<Courses>> getCourseById(@PathVariable("id") Long courseId){
        return ResponseEntity.ok(coursesService.getCourseById(courseId));
    }

    @GetMapping("/api/courses")
    public ResponseEntity<List<Courses>> getAllCourses(){
        return ResponseEntity.ok(coursesService.getAllCourses());
    }

    @PutMapping("/api/courses/{id}")
    public ResponseEntity<String> updateById(@PathVariable("id") Long courseId,
                                             @RequestBody Courses courseRequest){
        this.coursesService.createOrUpdateCourses(courseRequest);
        return ResponseEntity.ok().build();

    }

    @PostMapping("/api/courses")
    public ResponseEntity createCourses(@RequestBody Courses courseRequest){
        this.coursesService.createOrUpdateCourses(courseRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/courses/{id}")
    public ResponseEntity<List<Courses>> deleteCourseById(@PathVariable("id") Long courseId){
        return ResponseEntity.ok(coursesService.deleteById(courseId));
    }
}

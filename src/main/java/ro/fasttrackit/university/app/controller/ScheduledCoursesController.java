package ro.fasttrackit.university.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.university.app.model.ScheduledCourses;
import ro.fasttrackit.university.app.service.ScheduledCoursesService;

import java.util.List;

@RestController
public class ScheduledCoursesController {
    private final ScheduledCoursesService scheduledCoursesService;

    public ScheduledCoursesController (ScheduledCoursesService scheduledCoursesService){
        this.scheduledCoursesService = scheduledCoursesService;
    }

    @GetMapping("/api/scheduledCourses/{id}")
    public ResponseEntity<List<ScheduledCourses>> getScheduledCourseById(@PathVariable("id") Long scheduledCourseId){
        return ResponseEntity.ok(scheduledCoursesService.getScheduledCourseById(scheduledCourseId));
    }

    @GetMapping("/api/scheduledCourses")
    public ResponseEntity<List<ScheduledCourses>> getAllScheduledCourses(){
        return ResponseEntity.ok(scheduledCoursesService.getAllScheduledCourses());
    }

    @PutMapping("/api/scheduledCourses/{id}")
    public ResponseEntity<String> updateScheduledCourseById(@PathVariable("id") Long scheduledCourseId,
                                                            @RequestBody ScheduledCourses scheduledCoursesRequest){
        this.scheduledCoursesService.createOrUpdateScheduledCourse(scheduledCoursesRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/scheduledCourses")
    public ResponseEntity createScheduledCourses(@RequestBody ScheduledCourses scheduledCoursesRequest){
        this.scheduledCoursesService.createOrUpdateScheduledCourse(scheduledCoursesRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/scheduledCourses/{id}")
    public ResponseEntity<List<ScheduledCourses>> deleteScheduledCourseById(@PathVariable("id") Long scheduledCourseId){
        return ResponseEntity.ok(scheduledCoursesService.deleteScheduledCourseById(scheduledCourseId));
    }
}

package ro.fasttrackit.university.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.university.app.model.Student;
import ro.fasttrackit.university.app.service.StudentService;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService service){
        this.studentService = service;
    }

    @GetMapping("api/students/{id}")
    public ResponseEntity<List<Student>> getStudentById(@PathVariable("id") Long studentId){
        return ResponseEntity.ok(studentService.getStudentById(studentId));
    }

    @GetMapping("/api/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PutMapping("/api/students/{id}")
    public ResponseEntity<String> updateById(@PathVariable("id") Long studentId,
                                             @RequestBody Student studentRequest) {
        if (studentService.getStudentById(studentId).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        studentRequest.setId(studentId);
        this.studentService.createOrUpdateStudent(studentRequest);
        return ResponseEntity.ok("Student updated successfully");
    }

    @PostMapping("/api/students")
    public ResponseEntity createStudents(@RequestBody Student studentRequest){
        this.studentService.createOrUpdateStudent(studentRequest);
        return ResponseEntity.ok().build();
    }



    @DeleteMapping("/api/students/{id}")
    public ResponseEntity<List<Student>> deleteStudentById(@PathVariable("id") Long studentId) {
        return ResponseEntity.ok(studentService.deleteById(studentId));
    }

}

package ro.fasttrackit.university.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.university.app.model.Semester;
import ro.fasttrackit.university.app.repository.SemesterRepository;
import ro.fasttrackit.university.app.service.SemesterService;

import java.util.List;

@RestController
public class SemesterController {

    private final SemesterService semesterService;

    public SemesterController(SemesterService semesterService){
        this.semesterService = semesterService;
    }

    @GetMapping("/api/semester/{id}")
    public ResponseEntity<List<Semester>> getSemesterById(@PathVariable("id") Long semesterId){
        return ResponseEntity.ok(semesterService.getSemesterById(semesterId));
    }

    @GetMapping("/api/semester")
    public ResponseEntity<List<Semester>> gelAllSemesters(){
        return ResponseEntity.ok(semesterService.getAllSemesters());
    }

    @PutMapping("/api/semester/{id}")
    public ResponseEntity<String> updateSemesterById(@PathVariable("id") Long semesterId,
                                                     @RequestBody Semester semesterRequest){
        this.semesterService.createOrUpdateSemester(semesterRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/semester")
    public ResponseEntity createSemesters(@RequestBody Semester semesterRequest){
        this.semesterService.createOrUpdateSemester(semesterRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/semester/{id}")
    public ResponseEntity<List<Semester>> deleteSemesterById(@PathVariable("id") Long semesterId){
        return ResponseEntity.ok(semesterService.deleteById(semesterId));
    }
}

package ro.fasttrackit.university.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.university.app.model.Professor;
import ro.fasttrackit.university.app.service.ProfessorService;

import java.util.List;

@RestController
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService){
        this.professorService=professorService;
    }

    @GetMapping("/api/professors/{id}")
    public ResponseEntity<List<Professor>> getProfessorById(@PathVariable("id") Long professorId){
        return ResponseEntity.ok(professorService.getProfessorById(professorId));
    }

    @GetMapping("/api/professors")
    public ResponseEntity<List<Professor>> getAllProfessors(){
        return ResponseEntity.ok(professorService.getAllProfessors());
    }

    @PutMapping("/api/professors/{id}")
    public ResponseEntity<String> updateProfessorById(@PathVariable("id") Long professorId,
                                                      @RequestBody Professor professorRequest){
        this.professorService.createOrUpdateProfessor(professorRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/professors")
    public ResponseEntity createProfessors(@RequestBody Professor professorRequest){
        this.professorService.createOrUpdateProfessor(professorRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/professors/{id}")
    public ResponseEntity<List<Professor>> deleteProfessorById(@PathVariable("id") Long professorId){
        return ResponseEntity.ok(professorService.deleteProfessorById(professorId));
    }
}

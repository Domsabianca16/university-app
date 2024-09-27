package ro.fasttrackit.university.app.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.university.app.model.Professor;
import ro.fasttrackit.university.app.repository.ProfessorRepository;
import ro.fasttrackit.university.app.repository.dao.ProfessorEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> deleteProfessorById(Long id) {
        final List<ProfessorEntity> deletedById = this.professorRepository.findAll()
                .stream()
                .filter(professorEntity -> professorEntity.getId().equals(id))
                .collect(Collectors.toList());
        deletedById.forEach(professorEntity -> this.professorRepository.deleteById(professorEntity.getId()));
        return deletedById.stream()
                .map(professorEntity -> {
                    Professor professor = new Professor();
                    professor.setId(professorEntity.getId());
                    return professor;
                })
                .collect(Collectors.toList());
    }


    public List<Professor> getAllProfessors() {
        final List<ProfessorEntity> all = this.professorRepository.findAll();
        return all.stream()
                .map(professorEntity -> {
                    Professor createdProfessor = new Professor();
                    createdProfessor.setId(professorEntity.getId());
                    return createdProfessor;
                })
                .collect(Collectors.toList());
    }

    public void createOrUpdateProfessor(Professor toCreate) {
        ProfessorEntity createOrUpdateMe = new ProfessorEntity();
        createOrUpdateMe.setId(toCreate.getId());
        this.professorRepository.save(createOrUpdateMe);
    }

    public List<Professor> getProfessorById(Long id) {
        final List<ProfessorEntity> professorById = this.professorRepository.findAll();
        return professorById.stream()
                .filter(professorEntity -> professorEntity.getId().equals(id))
                .map(professorEntity -> {
                    Professor professor = new Professor();
                    professor.setId(professorEntity.getId());
                    return professor;
                })
                .collect(Collectors.toList());
    }


}

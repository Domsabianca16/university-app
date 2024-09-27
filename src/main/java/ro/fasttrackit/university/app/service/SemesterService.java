package ro.fasttrackit.university.app.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ro.fasttrackit.university.app.model.Semester;
import ro.fasttrackit.university.app.repository.SemesterRepository;
import ro.fasttrackit.university.app.repository.dao.SemesterEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SemesterService {

    private final SemesterRepository semesterRepository;

    public SemesterService(SemesterRepository semesterRepository){
        this.semesterRepository=semesterRepository;
    }

    public List<Semester> getAllSemesters(){
        final List<SemesterEntity> all=this.semesterRepository.findAll();
        return all.stream().map(semesterEntity -> {
            Semester semester = new Semester();
            semester.setId(semesterEntity.getId());
            semester.setUniversityDept(semesterEntity.getUniversityDept());
            semester.setUniversityYear(semesterEntity.getUniversityYear());
            semester.setSemesterNo(semesterEntity.getSemesterNo());
            semester.setStartDate(semesterEntity.getStartDate());
            semester.setEndDate(semesterEntity.getEndDate());
            return semester;
        })
                .collect(Collectors.toList());
    }

    public List<Semester> deleteById(Long id){
        final List<SemesterEntity> deletedById =this.semesterRepository.findAll()
                .stream().filter(semesterEntity -> semesterEntity.getId().equals(id))
                .collect(Collectors.toList());
        deletedById.forEach(semesterEntity -> this.semesterRepository.deleteById(semesterEntity.getId()));
        return deletedById.stream().map(semesterEntity -> {
            Semester semester = new Semester();
            semester.setId(semesterEntity.getId());
            semester.setUniversityDept(semesterEntity.getUniversityDept());
            semester.setUniversityYear(semesterEntity.getUniversityYear());
            semester.setSemesterNo(semesterEntity.getSemesterNo());
            semester.setStartDate(semesterEntity.getStartDate());
            semester.setEndDate(semesterEntity.getEndDate());
            return semester;
        })
                .collect(Collectors.toList());
    }

    public void createOrUpdateSemester(Semester semester){
        SemesterEntity createOrUpdateMe = new SemesterEntity();
        createOrUpdateMe.setId(semester.getId());
        createOrUpdateMe.setUniversityDept(semester.getUniversityDept());
        createOrUpdateMe.setUniversityYear(semester.getUniversityYear());
        createOrUpdateMe.setSemesterNo(semester.getSemesterNo());
        createOrUpdateMe.setStartDate(semester.getStartDate());
        createOrUpdateMe.setEndDate(semester.getEndDate());
        this.semesterRepository.save(createOrUpdateMe);
    }

    public List<Semester> getSemesterById(Long id){
        final List<SemesterEntity> semesterById = this.semesterRepository.findAll();
        return semesterById.stream().filter(semesterEntity -> semesterEntity.getId().equals(id))
                .map(semesterEntity -> {
                    Semester semester= new Semester();
                    semester.setId(semesterEntity.getId());
                    semester.setUniversityDept(semesterEntity.getUniversityDept());
                    semester.setUniversityYear(semesterEntity.getUniversityYear());
                    semester.setSemesterNo(semesterEntity.getSemesterNo());
                    semester.setStartDate(semesterEntity.getStartDate());
                    semester.setEndDate(semesterEntity.getEndDate());
                    return semester;
                })
                .collect(Collectors.toList());
    }


}

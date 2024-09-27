package ro.fasttrackit.university.app.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.university.app.model.Student;
import ro.fasttrackit.university.app.repository.StudentRepository;
import ro.fasttrackit.university.app.repository.dao.StudentEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> deleteById(Long id) {
        final List<StudentEntity> deletedById = this.studentRepository.findAll()
                .stream()
                .filter(studentEntity -> studentEntity.getId().equals(id))
                .toList();
        deletedById.forEach(studentEntity -> this.studentRepository.deleteById(studentEntity.getId()));
        return deletedById.stream()
                .map(studentEntity -> {
                    Student student = new Student();
                    student.setId(studentEntity.getId());
                    return student;
                })
                .collect(Collectors.toList());
    }


    public List<Student> getAllStudents(){
        final List<StudentEntity> all = this.studentRepository.findAll();
        return all.stream()
                .map(studentEntity -> {
                    Student createdStudent = new Student();
                    createdStudent.setId(studentEntity.getId());
                    return createdStudent;
                })
                .collect(Collectors.toList());
    }

    public void createOrUpdateStudent(Student toCreate){
        StudentEntity createOrUpdateMeStudent = new StudentEntity();
        createOrUpdateMeStudent.setId(toCreate.getId());
        this.studentRepository.save(createOrUpdateMeStudent);


    }
    public List<Student> getStudentById(Long id) {
        final List<StudentEntity> studentById = this.studentRepository.findAll();
        return studentById.stream()
                .filter(humanEntity -> humanEntity.getId().equals(id))
                .map(humanEntity -> {
                    Student student = new Student();
                    student.setId(humanEntity.getId());
                    return student;
                })
                .collect(Collectors.toList());
    }

}

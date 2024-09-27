package ro.fasttrackit.university.app.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.university.app.model.ScheduledCourses;
import ro.fasttrackit.university.app.model.StudentCourses;
import ro.fasttrackit.university.app.repository.StudentCoursesRepository;
import ro.fasttrackit.university.app.repository.dao.ScheduledCoursesEntity;
import ro.fasttrackit.university.app.repository.dao.StudentCourseEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentCoursesService {
    private final StudentCoursesRepository studentCoursesRepository;

    public StudentCoursesService(StudentCoursesRepository studentCoursesRepository ){
        this.studentCoursesRepository = studentCoursesRepository;
    }

    public List<StudentCourses> getAllStudentCourses() {
        final List<StudentCourseEntity> all = this.studentCoursesRepository.findAll();
        return all.stream().map(studentCourseEntity -> {
            StudentCourses studentCourses = new StudentCourses();
            studentCourses.setStudent_courses_id(studentCourseEntity.getScheduledCoursesEntity().getId());
            studentCourses.setStudent_id(studentCourseEntity.getStudentEntity().getId());
            return studentCourses;
        }).collect(Collectors.toList());
    }

    public List<StudentCourses> deleteStudentCourseById(Long id) {
        final List<StudentCourseEntity> deletedById = this.studentCoursesRepository.findAll()
                .stream().filter(studentCourseEntity -> studentCourseEntity.getStudentEntity().getId().equals(id))
                .collect(Collectors.toList());
        deletedById.forEach(studentCourseEntity -> this.studentCoursesRepository.deleteById(studentCourseEntity.getStudentEntity().getId()));
        return deletedById.stream().map(studentCourseEntity -> {
                    StudentCourses studentCourses = new StudentCourses();
                    studentCourses.setStudent_id(studentCourseEntity.getStudentEntity().getId());
                    studentCourses.setStudent_courses_id(studentCourseEntity.getScheduledCoursesEntity().getId());
                    return studentCourses;
                })
                .collect(Collectors.toList());
    }

    //public void createOrUpdateStudentCourse(StudentCourses toCreate) {
      //  StudentCourseEntity createOrUpdateMe = new StudentCourseEntity();
        //createOrUpdateMe.s(toCreate.);
        //this.scheduledCoursesRepository.save(createOrUpdateMe);
    //}

    public List<StudentCourses> getStudentCourseById(Long id) {
        final List<StudentCourseEntity> studentCourseById = this.studentCoursesRepository.findAll();
        return studentCourseById.stream().filter(studentCourseEntity -> studentCourseEntity.getStudentEntity().getId().equals(id))
                .map(scheduledCoursesEntity -> {
                    StudentCourses studentCourses = new StudentCourses();
                    studentCourses.setStudent_id(studentCourses.getStudent_id());
                    studentCourses.setStudent_courses_id(studentCourses.getStudent_courses_id());
                    return studentCourses;
                })
                .collect(Collectors.toList());
    }

}

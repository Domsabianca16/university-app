package ro.fasttrackit.university.app.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.university.app.model.Courses;
import ro.fasttrackit.university.app.model.Human;
import ro.fasttrackit.university.app.repository.CourseRepository;
import ro.fasttrackit.university.app.repository.dao.CoursesEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoursesService {

    private final CourseRepository courseRepository;

    public CoursesService(CourseRepository courseRepository){
        this.courseRepository=courseRepository;
    }

    public List<Courses> deleteById(Long id){
        final List<CoursesEntity> deletedById = this.courseRepository.findAll()
                .stream().filter(coursesEntity -> coursesEntity.getId().equals(id))
                .collect(Collectors.toList());
        deletedById.forEach(coursesEntity -> this.courseRepository.deleteById(coursesEntity.getId()));
        return deletedById.stream().map(coursesEntity ->{
            Courses courses = new Courses();
            courses.setId(coursesEntity.getId());
            return courses;
        })
                .collect(Collectors.toList());
    }
    public List<Courses> getAllCourses(){
        final List<CoursesEntity> all = this.courseRepository.findAll();
        return all.stream()
                .map(coursesEntity -> {
                    Courses courses = new Courses();
                    courses.setId(coursesEntity.getId());
                    return courses;
                })
                .collect(Collectors.toList());
    }

    public void createOrUpdateCourses(Courses toCreate){
        CoursesEntity createOrUpdateMe = new CoursesEntity();
        createOrUpdateMe.setId(toCreate.getId());
        this.courseRepository.save(createOrUpdateMe);
    }

    public List<Courses> getCourseById(Long id){
        final List<CoursesEntity> courseById = this.courseRepository.findAll();
        return courseById.stream().filter(coursesEntity -> coursesEntity.getId().equals(id))
                .map(coursesEntity -> {
                    Courses courses = new Courses();
                    courses.setId(coursesEntity.getId());
                    return courses;
                })
                .collect(Collectors.toList());
    }
}

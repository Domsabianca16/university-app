package ro.fasttrackit.university.app.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.university.app.model.ScheduledCourses;
import ro.fasttrackit.university.app.repository.ScheduledCoursesRepository;
import ro.fasttrackit.university.app.repository.dao.ScheduledCoursesEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduledCoursesService {
    private final ScheduledCoursesRepository scheduledCoursesRepository;

    public ScheduledCoursesService(ScheduledCoursesRepository scheduledCoursesRepository) {
        this.scheduledCoursesRepository = scheduledCoursesRepository;
    }

    public List<ScheduledCourses> getAllScheduledCourses() {
        final List<ScheduledCoursesEntity> all = this.scheduledCoursesRepository.findAll();
        return all.stream().map(scheduledCoursesEntity -> {
            ScheduledCourses scheduledCourses = new ScheduledCourses();
            scheduledCourses.setCourseId(scheduledCoursesEntity.getId());
            return scheduledCourses;
        }).collect(Collectors.toList());
    }

    public List<ScheduledCourses> deleteScheduledCourseById(Long id) {
        final List<ScheduledCoursesEntity> deletedById = this.scheduledCoursesRepository.findAll()
                .stream().filter(scheduledCoursesEntity -> scheduledCoursesEntity.getId().equals(id))
                .collect(Collectors.toList());
        deletedById.forEach(scheduledCoursesEntity -> this.scheduledCoursesRepository.deleteById(scheduledCoursesEntity.getId()));
        return deletedById.stream().map(scheduledCoursesEntity -> {
                    ScheduledCourses scheduledCourses = new ScheduledCourses();
                    scheduledCourses.setId(scheduledCoursesEntity.getId());
                    return scheduledCourses;
                })
                .collect(Collectors.toList());
    }

    public void createOrUpdateScheduledCourse(ScheduledCourses toCreate) {
        ScheduledCoursesEntity createOrUpdateMe = new ScheduledCoursesEntity();
        createOrUpdateMe.setId(toCreate.getId());
        this.scheduledCoursesRepository.save(createOrUpdateMe);
    }

    public List<ScheduledCourses> getScheduledCourseById(Long id) {
        final List<ScheduledCoursesEntity> scheduledCourseById = this.scheduledCoursesRepository.findAll();
        return scheduledCourseById.stream().filter(scheduledCoursesEntity -> scheduledCoursesEntity.getId().equals(id))
                .map(scheduledCoursesEntity -> {
                    ScheduledCourses scheduledCourses = new ScheduledCourses();
                    scheduledCourses.setId(scheduledCoursesEntity.getId());
                    return scheduledCourses;
                })
                .collect(Collectors.toList());
    }
}

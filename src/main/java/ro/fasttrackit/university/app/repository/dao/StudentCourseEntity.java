package ro.fasttrackit.university.app.repository.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "student_courses")
@IdClass(StudentCoursesId.class)
public class StudentCourseEntity {
        @Id
        @ManyToOne
        @JoinColumn(name = "student_id", referencedColumnName = "id")
        private StudentEntity studentEntity;

        @Id
        @ManyToOne
        @JoinColumn(name = "scheduled_course_id", referencedColumnName = "id")
        private ScheduledCoursesEntity scheduledCoursesEntity;

        // Getters and setters
        public StudentEntity getStudentEntity() {
            return studentEntity;
        }

        public void setStudentEntity(StudentEntity studentEntity) {
            this.studentEntity = studentEntity;
        }

        public ScheduledCoursesEntity getScheduledCoursesEntity() {
            return scheduledCoursesEntity;
        }

        public void setScheduledCoursesEntity(ScheduledCoursesEntity scheduledCoursesEntity) {
            this.scheduledCoursesEntity = scheduledCoursesEntity;
        }
    }

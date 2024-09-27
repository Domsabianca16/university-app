package ro.fasttrackit.university.app.repository.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "scheduled_courses")
public class ScheduledCoursesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private ProfessorEntity professorEntity;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CoursesEntity coursesEntity;

    @ManyToOne
    @JoinColumn(name = "semester_id")
    private SemesterEntity semesterEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProfessorEntity getProfessorEntity() {
        return professorEntity;
    }

    public void setProfessorEntity(ProfessorEntity professorEntity) {
        this.professorEntity = professorEntity;
    }

    public CoursesEntity getCoursesEntity() {
        return coursesEntity;
    }

    public void setCoursesEntity(CoursesEntity coursesEntity) {
        this.coursesEntity = coursesEntity;
    }

    public SemesterEntity getSemesterEntity() {
        return semesterEntity;
    }

    public void setSemesterEntity(SemesterEntity semesterEntity) {
        this.semesterEntity = semesterEntity;
    }
}

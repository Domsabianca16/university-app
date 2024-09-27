package ro.fasttrackit.university.app.model;

import ro.fasttrackit.university.app.repository.dao.ScheduledCoursesEntity;

import java.util.Objects;

public class StudentCourses {
    private Long student_id;
    private Long student_courses_id;

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public Long getStudent_courses_id() {
        return student_courses_id;
    }

    public void setStudent_courses_id(Long student_courses_id) {
        this.student_courses_id = student_courses_id;
    }

    @Override
    public String toString() {
        return "StudentCourses{" +
                "student_id=" + student_id +
                ", student_courses_id=" + student_courses_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentCourses that = (StudentCourses) o;
        return Objects.equals(student_id, that.student_id) && Objects.equals(student_courses_id, that.student_courses_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student_id, student_courses_id);
    }
}

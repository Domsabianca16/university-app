package ro.fasttrackit.university.app.repository.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StudentCoursesId implements Serializable {
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "scheduled_course_id")
    private Long scheduledCourseId;

    // Getters, setters, equals, and hashCode methods
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getScheduledCourseId() {
        return scheduledCourseId;
    }

    public void setScheduledCourseId(Long scheduledCourseId) {
        this.scheduledCourseId = scheduledCourseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentCoursesId)) return false;
        StudentCoursesId that = (StudentCoursesId) o;
        return Objects.equals(getStudentId(), that.getStudentId()) && Objects.equals(getScheduledCourseId(), that.getScheduledCourseId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId(), getScheduledCourseId());
    }
}

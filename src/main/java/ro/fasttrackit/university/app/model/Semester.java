package ro.fasttrackit.university.app.model;

import java.time.LocalDate;
import java.util.Objects;

public class Semester {
    private Long id;
    private String universityDept;
    private int universityYear;
    private int semesterNo;
    private LocalDate startDate;
    private LocalDate endDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniversityDept() {
        return universityDept;
    }

    public void setUniversityDept(String universityDept) {
        this.universityDept = universityDept;
    }

    public int getUniversityYear() {
        return universityYear;
    }

    public void setUniversityYear(int universityYear) {
        this.universityYear = universityYear;
    }

    public int getSemesterNo() {
        return semesterNo;
    }

    public void setSemesterNo(int semesterNo) {
        this.semesterNo = semesterNo;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Semester{" +
                "id=" + id +
                ", universityDept='" + universityDept + '\'' +
                ", universityYear=" + universityYear +
                ", semesterNo=" + semesterNo +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Semester semester = (Semester) o;
        return universityYear == semester.universityYear && semesterNo == semester.semesterNo && Objects.equals(id, semester.id) && Objects.equals(universityDept, semester.universityDept) && Objects.equals(startDate, semester.startDate) && Objects.equals(endDate, semester.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, universityDept, universityYear, semesterNo, startDate, endDate);
    }
}

package ro.fasttrackit.university.app.repository.dao;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "semester")
public class SemesterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "university_dept")
    private String universityDept;
    @Column(name = "university_year")
    private int universityYear;
    @Column(name = "semester_no")
    private int semesterNo;
    @Column(name="start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
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
}

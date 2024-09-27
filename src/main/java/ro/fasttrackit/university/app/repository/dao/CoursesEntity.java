package ro.fasttrackit.university.app.repository.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class CoursesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}

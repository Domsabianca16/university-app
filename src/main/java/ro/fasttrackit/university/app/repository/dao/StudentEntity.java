package ro.fasttrackit.university.app.repository.dao;

import jakarta.persistence.*;


@Entity
@Table(name = "students")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "human_id")
   private HumanEntity humanEntity1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public HumanEntity getHumanEntity() {
        return humanEntity1;
    }

    public void setHumanEntity(HumanEntity humanEntity) {
        this.humanEntity1 = humanEntity;
    }
}

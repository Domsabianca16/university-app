package ro.fasttrackit.university.app.repository.dao;

import jakarta.persistence.*;
import org.hibernate.annotations.ValueGenerationType;

@Entity
@Table(name = "professor")
public class ProfessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "human_id")
    private HumanEntity humanEntity2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public HumanEntity getHumanEntity() {
        return humanEntity2;
    }

    public void setHumanEntity(HumanEntity humanEntity) {
        this.humanEntity2 = humanEntity;
    }
}

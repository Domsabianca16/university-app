package ro.fasttrackit.university.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.university.app.repository.dao.ProfessorEntity;

public interface ProfessorRepository extends JpaRepository<ProfessorEntity,Long> {
}

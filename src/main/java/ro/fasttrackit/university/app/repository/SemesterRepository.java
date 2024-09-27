package ro.fasttrackit.university.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.university.app.repository.dao.SemesterEntity;

@Repository
public interface SemesterRepository extends JpaRepository<SemesterEntity,Long> {
}

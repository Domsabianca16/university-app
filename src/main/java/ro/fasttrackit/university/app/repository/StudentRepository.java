package ro.fasttrackit.university.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.university.app.model.Student;
import ro.fasttrackit.university.app.repository.dao.StudentEntity;

@Repository
public interface StudentRepository  extends JpaRepository<StudentEntity, Long> {
}

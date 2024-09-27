package ro.fasttrackit.university.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.university.app.repository.dao.CoursesEntity;

@Repository
public interface CourseRepository extends JpaRepository<CoursesEntity,Long> {
}

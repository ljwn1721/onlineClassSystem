package est.onlineClassSystem.repository;

import est.onlineClassSystem.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

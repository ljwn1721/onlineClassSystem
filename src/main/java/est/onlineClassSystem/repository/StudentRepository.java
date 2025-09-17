package est.onlineClassSystem.repository;

import est.onlineClassSystem.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

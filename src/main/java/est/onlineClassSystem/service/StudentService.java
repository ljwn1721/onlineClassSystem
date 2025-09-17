package est.onlineClassSystem.service;

import est.onlineClassSystem.domain.Course;
import est.onlineClassSystem.domain.Enrollment;
import est.onlineClassSystem.domain.Student;
import est.onlineClassSystem.dto.EnrollResponse;
import est.onlineClassSystem.repository.CourseRepository;
import est.onlineClassSystem.repository.EnrollmentRepository;
import est.onlineClassSystem.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService{
    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Transactional
    public EnrollResponse enroll(Long studentId, Long courseId){
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));

        // 중복 수강 체크
        enrollmentRepository.findByStudentIdAndCourseId(studentId, courseId)
                .ifPresent(e -> {
                    throw new ResponseStatusException(HttpStatus.CONFLICT, "Already enrolled in this course");
                });

        Enrollment enrollment = Enrollment.builder()
                .enrollmentDate(LocalDate.now())
                .student(student)
                .course(course)
                .build();

        return new EnrollResponse(enrollmentRepository.save(enrollment));
    }

    public List<EnrollResponse> findEnrolledCourses(Long studentId){
        studentRepository.findById(studentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));

        return enrollmentRepository.findByStudentId(studentId)
                                    .stream()
                                    .map(EnrollResponse::new)
                                    .toList();

    }

}

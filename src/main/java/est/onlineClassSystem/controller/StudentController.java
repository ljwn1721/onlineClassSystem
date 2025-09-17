package est.onlineClassSystem.controller;

import est.onlineClassSystem.domain.Enrollment;
import est.onlineClassSystem.domain.Student;
import est.onlineClassSystem.dto.EnrollRequest;
import est.onlineClassSystem.dto.EnrollResponse;
import est.onlineClassSystem.repository.EnrollmentRepository;
import est.onlineClassSystem.repository.StudentRepository;
import est.onlineClassSystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/students")
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/{studentId}/enrolls")
    public ResponseEntity<EnrollResponse> enrollCourse(@PathVariable Long studentId, @RequestBody EnrollRequest request) {
        EnrollResponse response = studentService.enroll(studentId, request.getCourseId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{studentId}/enrolls")
    public ResponseEntity<List<EnrollResponse>> getEnrolledCourses(@PathVariable Long studentId) {
        List<EnrollResponse> responses = studentService.findEnrolledCourses(studentId);
        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }


}

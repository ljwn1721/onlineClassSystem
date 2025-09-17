package est.onlineClassSystem.dto;

import est.onlineClassSystem.domain.Enrollment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class EnrollResponse {
    private String title;
    private String instructor;
    private LocalDate enrollmentDate;

    public EnrollResponse(Enrollment enrollment) {
        this.title = enrollment.getCourse().getTitle();
        this.instructor = enrollment.getCourse().getInstructor();
        this.enrollmentDate = enrollment.getEnrollmentDate();
    }
}

package com.academiccourseregistration.core.web;

import com.academiccourseregistration.core.api.model.CourseDto;
import com.academiccourseregistration.core.api.model.ProfessorDto;
import com.academiccourseregistration.core.api.model.StudentDto;
import com.academiccourseregistration.core.service.CourseService;
import com.academiccourseregistration.core.service.ProfessorService;
import com.academiccourseregistration.core.service.StudentService;
import com.academiccourseregistration.core.web.controller.AcademicCourseRegistrationController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import static com.academiccourseregistration.core.web.controller.AcademicCourseRegistrationController.API;
import static com.academiccourseregistration.core.web.controller.AcademicCourseRegistrationController.COURSES;
import static com.academiccourseregistration.core.web.controller.AcademicCourseRegistrationController.PROFESSORS;
import static com.academiccourseregistration.core.web.controller.AcademicCourseRegistrationController.STUDENTS;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = AcademicCourseRegistrationController.class)
@MockBean({ProfessorService.class, CourseService.class})
public class AcademicCourseRegistrationControllerTest {

    @MockBean
    private CourseService courseService;

    @MockBean
    private StudentService studentService;

    @MockBean
    private ProfessorService professorService;

    @Autowired
    private WebTestClient webClient;

    @Test
    public void addCourseTest()
    {
        CourseDto course = new CourseDto();

        course.setId(1L);
        course.setName("Course");

        Mockito.when(courseService.save(course)).thenReturn(Mono.just(course));

        webClient.post()
                .uri(API + COURSES)
                .contentType(APPLICATION_JSON)
                .body(BodyInserters.fromObject(course))
                .exchange()
                .expectStatus().isCreated()
                .expectBody().jsonPath("$", is(course));

        Mockito.verify(courseService, times(1)).save(course);
    }

    @Test
    public void addStudentTest()
    {
        StudentDto student = new StudentDto();

        student.setId(1L);
        student.setFirstName("FirstName");
        student.setLastName("LastName");

        Mockito.when(studentService.save(student)).thenReturn(Mono.just(student));

        webClient.post()
                .uri(API + STUDENTS)
                .contentType(APPLICATION_JSON)
                .body(BodyInserters.fromObject(student))
                .exchange()
                .expectStatus().isCreated()
                .expectBody().jsonPath("$", is(student));

        Mockito.verify(studentService, times(1)).save(student);
    }

    @Test
    public void addProfessorTest()
    {
        ProfessorDto professor = new ProfessorDto();

        professor.setId(1L);
        professor.setFirstName("P_Firstname");
        professor.setLastName("P_Lastname");

        Mockito.when(professorService.save(professor)).thenReturn(Mono.just(professor));

        webClient.post()
                .uri(API + PROFESSORS)
                .contentType(APPLICATION_JSON)
                .body(BodyInserters.fromObject(professor))
                .exchange()
                .expectStatus().isCreated()
                .expectBody().jsonPath("$", is(professor));

        Mockito.verify(professorService, times(1)).save(professor);
    }
}
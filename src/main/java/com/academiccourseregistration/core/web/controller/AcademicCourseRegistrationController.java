package com.academiccourseregistration.core.web.controller;

import static org.springframework.http.HttpStatus.CREATED;

import static com.academiccourseregistration.core.web.controller.AcademicCourseRegistrationController.API;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.academiccourseregistration.core.api.model.CourseDto;
import com.academiccourseregistration.core.api.model.ProfessorDto;
import com.academiccourseregistration.core.api.model.StudentDto;
import com.academiccourseregistration.core.service.CourseService;
import com.academiccourseregistration.core.service.ProfessorService;
import com.academiccourseregistration.core.service.StudentService;
import com.academiccourseregistration.core.web.dto.CourseIds;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(API)
public class AcademicCourseRegistrationController {

    public static final String API = "/api";

    public static final String STUDENTS = "/students";
    public static final String COURSES = "/courses";
    public static final String PROFESSORS = "/professors";

    public static final String STUDENT_ID = "/{studentId}";

    public static final String REGISTER_STUDENT = COURSES + "/{courseId}" + STUDENTS + STUDENT_ID;
    public static final String ASSIGN_PROFESSOR = COURSES + "/{courseId}" + PROFESSORS + "/{professorId}";
    public static final String REGISTER_STUDENT_TO_LIST_OF_COURSES = STUDENTS + STUDENT_ID + COURSES;

    private final CourseService courseService;
    private final StudentService studentService;
    private final ProfessorService professorService;

    @PostMapping(PROFESSORS)
    @ResponseStatus(CREATED)
    public Mono<ProfessorDto> addProfessor(@NotNull @Valid @RequestBody ProfessorDto professor) {
        return professorService.save(professor);
    }

    @PostMapping(STUDENTS)
    @ResponseStatus(CREATED)
    public Mono<StudentDto> addStudent(@NotNull @Valid @RequestBody StudentDto student) {
        return studentService.save(student);
    }

    @PostMapping(COURSES)
    @ResponseStatus(CREATED)
    public Mono<CourseDto> addCourse(@NotNull @Valid @RequestBody CourseDto course) {
        return courseService.save(course);
    }

    @PutMapping(REGISTER_STUDENT)
    public void registerStudentToCourse(@NotNull @PathVariable Long courseId,
            @NotNull @PathVariable Long studentId) {
        courseService.registerStudentToCourse(courseId, studentId);
    }

    @PutMapping(ASSIGN_PROFESSOR)
    public void assignProfessorToCourse(@NotNull @PathVariable Long courseId,
            @NotNull @PathVariable Long professorId) {
        courseService.assignProfessorToCourse(courseId, professorId);
    }

    @PutMapping(REGISTER_STUDENT_TO_LIST_OF_COURSES)
    public void registerStudentToListOfCourses(@NotNull @PathVariable Long studentId,
            @NotNull @RequestBody CourseIds courseIds) {
        courseService.registerStudentToListOfCourses(studentId, courseIds.getCourseIds());
    }
}
package com.academiccourseregistration.core.service;

import java.util.Collection;

import javax.validation.constraints.NotNull;

import com.academiccourseregistration.core.api.model.CourseDto;

import reactor.core.publisher.Mono;

public interface CourseService {

    Mono<CourseDto> save(@NotNull CourseDto course);

    void registerStudentToCourse(@NotNull Long courseId, @NotNull Long studentId);

    void assignProfessorToCourse(@NotNull Long courseId, @NotNull Long professorId);

    void registerStudentToListOfCourses(@NotNull Long studentId, @NotNull Collection<Long> courseIds);
}

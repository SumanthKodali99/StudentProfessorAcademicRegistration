package com.academiccourseregistration.core.service;

import javax.validation.constraints.NotNull;

import com.academiccourseregistration.core.api.model.StudentDto;

import reactor.core.publisher.Mono;

public interface StudentService {

    Mono<StudentDto> save(@NotNull StudentDto student);
}

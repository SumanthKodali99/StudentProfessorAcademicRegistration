package com.academiccourseregistration.core.service;

import javax.validation.constraints.NotNull;

import com.academiccourseregistration.core.api.model.ProfessorDto;

import reactor.core.publisher.Mono;

public interface ProfessorService {

    Mono<ProfessorDto> save(@NotNull ProfessorDto professor);
}

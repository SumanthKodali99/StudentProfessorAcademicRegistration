package com.academiccourseregistration.core.service.impl;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.academiccourseregistration.core.api.model.ProfessorDto;
import com.academiccourseregistration.core.dao.mapper.ProfessorMapper;
import com.academiccourseregistration.core.dao.model.Professor;
import com.academiccourseregistration.core.dao.repo.ProfessorRepository;
import com.academiccourseregistration.core.service.CourseService;
import com.academiccourseregistration.core.service.ProfessorService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@Validated
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;

    @Override
    public Mono<ProfessorDto> save(@NotNull ProfessorDto professor) {
        Professor saved = professorRepository.save(ProfessorMapper.toEntity(professor));
        return Mono.just(ProfessorMapper.toDto(saved));
    }
}
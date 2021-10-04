package com.academiccourseregistration.core.service.impl;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.academiccourseregistration.core.api.model.StudentDto;
import com.academiccourseregistration.core.dao.mapper.StudentMapper;
import com.academiccourseregistration.core.dao.model.Student;
import com.academiccourseregistration.core.dao.repo.StudentRepository;
import com.academiccourseregistration.core.service.StudentService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@Validated
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Mono<StudentDto> save(@NotNull StudentDto student) {
        Student saved = studentRepository.save(StudentMapper.toEntity(student));
        return Mono.just(StudentMapper.toDto(saved));
    }
}

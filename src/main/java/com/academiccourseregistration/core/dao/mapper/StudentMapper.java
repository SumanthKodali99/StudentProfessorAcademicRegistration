package com.academiccourseregistration.core.dao.mapper;

import com.academiccourseregistration.core.api.model.StudentDto;
import com.academiccourseregistration.core.dao.model.Student;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StudentMapper {

    public StudentDto toDto(Student entity) {
        StudentDto dto = new StudentDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        return dto;
    }

    public Student toEntity(StudentDto dto) {
        Student entity = new Student();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        return entity;
    }
}

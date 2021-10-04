package com.academiccourseregistration.core.dao.mapper;

import com.academiccourseregistration.core.api.model.ProfessorDto;
import com.academiccourseregistration.core.dao.model.Professor;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ProfessorMapper {

    public ProfessorDto toDto(Professor entity) {
        ProfessorDto dto = new ProfessorDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        return dto;
    }

    public Professor toEntity(ProfessorDto dto) {
        Professor entity = new Professor();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        return entity;
    }
}
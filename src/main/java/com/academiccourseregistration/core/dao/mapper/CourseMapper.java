package com.academiccourseregistration.core.dao.mapper;

import com.academiccourseregistration.core.api.model.CourseDto;
import com.academiccourseregistration.core.dao.model.Course;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CourseMapper {

    public static CourseDto toDto(Course entity) {
        CourseDto dto = new CourseDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public static Course toEntity(CourseDto dto) {
        Course entity = new Course();
        entity.setName(dto.getName());
        return entity;
    }
}
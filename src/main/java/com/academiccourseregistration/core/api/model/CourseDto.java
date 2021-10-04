package com.academiccourseregistration.core.api.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CourseDto {

    private Long id;

    @NotNull
    private String name;
}

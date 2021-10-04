package com.academiccourseregistration.core.api.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ProfessorDto {

    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private Long courseId;
}

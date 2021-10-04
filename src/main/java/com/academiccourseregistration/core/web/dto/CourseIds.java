package com.academiccourseregistration.core.web.dto;

import java.util.Collection;
import java.util.HashSet;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CourseIds {
    @NotNull
    Collection<Long> courseIds = new HashSet<>();
}

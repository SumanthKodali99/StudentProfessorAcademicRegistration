package com.academiccourseregistration.core.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academiccourseregistration.core.dao.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
package com.academiccourseregistration.core.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academiccourseregistration.core.dao.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
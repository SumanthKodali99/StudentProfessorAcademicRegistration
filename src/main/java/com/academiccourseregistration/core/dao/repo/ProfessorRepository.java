package com.academiccourseregistration.core.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academiccourseregistration.core.dao.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
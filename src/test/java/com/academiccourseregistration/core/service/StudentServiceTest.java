package com.academiccourseregistration.core.service;

import com.academiccourseregistration.core.api.model.StudentDto;
import com.academiccourseregistration.core.dao.mapper.StudentMapper;
import com.academiccourseregistration.core.dao.model.Student;
import com.academiccourseregistration.core.dao.repo.StudentRepository;
import com.academiccourseregistration.core.service.impl.StudentServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
public class StudentServiceTest {

    @InjectMocks
    private StudentServiceImpl studentService;
    @Mock
    private StudentRepository studentRepository;

    @Test
    public void saveStudentTest()
    {
        StudentDto studentDto = new StudentDto();
        studentDto.setFirstName("FirstName");
        studentDto.setFirstName("LastName");
        Student student = new Student(1L, "FirstName", "LastName", Collections.emptySet());

        Mockito.when(studentRepository.save(StudentMapper.toEntity(studentDto))).thenReturn(student);

        StudentDto created = studentService.save(studentDto).block();
        assertThat(created).isNotNull();
        assertThat(created.getFirstName().equals(studentDto.getFirstName()));
        assertThat(created.getLastName().equals(studentDto.getLastName()));
    }
}
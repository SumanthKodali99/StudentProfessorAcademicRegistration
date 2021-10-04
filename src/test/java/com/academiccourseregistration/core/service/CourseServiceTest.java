package com.academiccourseregistration.core.service;

import com.academiccourseregistration.core.api.model.CourseDto;
import com.academiccourseregistration.core.dao.mapper.CourseMapper;
import com.academiccourseregistration.core.dao.model.Course;
import com.academiccourseregistration.core.dao.model.Student;
import com.academiccourseregistration.core.dao.repo.CourseRepository;
import com.academiccourseregistration.core.dao.repo.ProfessorRepository;
import com.academiccourseregistration.core.dao.repo.StudentRepository;
import com.academiccourseregistration.core.service.impl.CourseServiceImpl;
import org.hibernate.service.spi.ServiceException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
public class CourseServiceTest {

    @InjectMocks
    private CourseServiceImpl courseService;
    @Mock
    private ProfessorRepository professorRepository;
    @Mock
    private CourseRepository courseRepository;
    @Mock
    private StudentRepository studentRepository;

    @Test
    public void saveCourseTest() {
        CourseDto courseDto = new CourseDto();
        courseDto.setName("Course");
        Course course = new Course(1L, "Course", null, Collections.emptySet());

        Mockito.when(courseRepository.save(CourseMapper.toEntity(courseDto))).thenReturn(course);

        CourseDto created = courseService.save(courseDto).block();
        assertThat(created).isNotNull();
        assertThat(created.getName().equals(courseDto.getName()));
        assertThat(created.getId()).isNotNull();
    }

    @Test
    public void studentHasMoreThanAcceptedCourses() {
        long courseId = 5;
        long studentId = 1;
        Set<Course> courses = new HashSet<>();
        courses.add(new Course(1L, "course_1", 1L, Collections.emptySet()));
        courses.add(new Course(2L, "course_2", 2L, Collections.emptySet()));
        courses.add(new Course(3L, "course_3", 3L, Collections.emptySet()));
        Student student = new Student(studentId, "f_name", "l_name", courses);

        Mockito.when(studentRepository.getById(studentId)).thenReturn(student);

        assertThrows(ServiceException.class, () ->
                courseService.registerStudentToCourse(courseId, studentId));
    }
}
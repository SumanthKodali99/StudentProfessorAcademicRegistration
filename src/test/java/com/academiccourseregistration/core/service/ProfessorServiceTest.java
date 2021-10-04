package com.academiccourseregistration.core.service;

import com.academiccourseregistration.core.api.model.ProfessorDto;
import com.academiccourseregistration.core.dao.mapper.ProfessorMapper;
import com.academiccourseregistration.core.dao.model.Professor;
import com.academiccourseregistration.core.dao.repo.ProfessorRepository;
import com.academiccourseregistration.core.service.impl.ProfessorServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
public class ProfessorServiceTest {

    @InjectMocks
    private ProfessorServiceImpl professorService;
    @Mock
    private ProfessorRepository professorRepository;

    @Test
    public void saveProfessorTest() {
        ProfessorDto professorDto = new ProfessorDto();
        professorDto.setFirstName("P_FirstName");
        professorDto.setFirstName("P_LastName");
        professorDto.setCourseId(1L);
        Professor professor = new Professor(1L, "FirstName", "LastName");

        Mockito.when(professorRepository.save(ProfessorMapper.toEntity(professorDto))).thenReturn(professor);

        ProfessorDto created = professorService.save(professorDto).block();
        assertThat(created).isNotNull();
        assertThat(created.getFirstName().equals(professorDto.getFirstName()));
        assertThat(created.getLastName().equals(professorDto.getLastName()));
    }
}